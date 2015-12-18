package cz.cvut.fit.run.vm.classfile;

import cz.cvut.fit.run.vm.classfile.attribute.Attribute;
import cz.cvut.fit.run.vm.classfile.attribute.Code;
import cz.cvut.fit.run.vm.classfile.attribute.ConstantValue;
import cz.cvut.fit.run.vm.classfile.attribute.NotImplementedAttribute;
import cz.cvut.fit.run.vm.classfile.constant.*;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Created by Keo on 8.12.2015.
 */
public class ClassFileLoader {

    public ClassFile loadClassFile(InputStream is) throws IOException {
        DataInputStream dis = new DataInputStream(is);
        if (!isJavaClassFile(dis)) {
            throw new RuntimeException("Not Java class file");
        }

        ClassFile classFile = new ClassFile();

        loadVersion(classFile, dis);
        loadConstantPool(classFile, dis);
        loadAccessFlags(classFile, dis);
        loadThisClassIndex(classFile, dis);
        loadSuperClassIndex(classFile, dis);
        loadInterfaces(classFile, dis);
        loadFields(classFile, dis);
        loadMethods(classFile, dis);
        loadAttributes(classFile, dis);

        return classFile;
    }

    protected void loadAttributes(ClassFile classFile, DataInputStream dis) throws IOException {
        classFile.attributes = readAttributes(classFile, dis);
    }

    protected Attribute[] readAttributes(ClassFile classFile, DataInputStream dis) throws IOException {
        Attribute[] attributes = new Attribute[dis.readShort()];
        for (int j = 0; j < attributes.length; j++) {
            attributes[j] = readAttributeItem(classFile, dis);
        }
        return attributes;
    }

    protected Attribute readAttributeItem(ClassFile classFile, DataInputStream dis) throws IOException {
        short nameIndex = dis.readShort();
        int length = dis.readInt();

        ConstantUTF8 cs = (ConstantUTF8) classFile.constants[nameIndex];
        switch (cs.string) {
            case "ConstantValue": {
                ConstantValue attribute = new ConstantValue(nameIndex, length);
                assert (attribute.length == 2);
                attribute.valueIndex = dis.readShort();
                return attribute;
            }

            case "Code": {
                Code attribute = new Code(nameIndex, length);
                attribute.maxStack = dis.readShort();
                attribute.maxLocals = dis.readShort();
                attribute.code = new byte[dis.readInt()];
                dis.read(attribute.code, 0, attribute.code.length);
                short exceptionCount = dis.readShort();
                assert (exceptionCount == 0);

                attribute.attributes = new Attribute[dis.readShort()];
                for (int i = 0; i < attribute.attributes.length; i++) {
                    attribute.attributes[i] = readAttributeItem(classFile, dis);
                }
                return attribute;
            }

            case "Exceptions": {
                cz.cvut.fit.run.vm.classfile.attribute.Exception exception = new cz.cvut.fit.run.vm.classfile.attribute.Exception(nameIndex, length);
                exception.exceptionIndexes = new short[dis.readShort()];
                for (int i = 0; i < exception.exceptionIndexes.length; i++) {
                    exception.exceptionIndexes[i] = dis.readShort();
                }
                return exception;
            }

            case "StackMapTable": // should be implemented, handles type check, but it is not necessary
            case "SourceFile":
            case "LineNumberTable":
            case "LocalVariableTypeTable":
            case "LocalVariableTable": {
                dis.skipBytes(length);
                return new NotImplementedAttribute();
            }

            default:
                throw new RuntimeException("Unknown type:" + cs.string);
        }
    }

    protected void loadMethods(ClassFile classFile, DataInputStream dis) throws IOException {
        short methodCount = dis.readShort();
        classFile.methods = new Method[methodCount];

        for (int i = 0; i < methodCount; i++) {
            Method method = new Method();
            method.accessFlags = dis.readShort();
            method.nameIndex = dis.readShort();
            method.descriptionIndex = dis.readShort();
            method.attributes = readAttributes(classFile, dis);
            classFile.methods[i] = method;
        }
    }

    protected void loadFields(ClassFile classFile, DataInputStream dis) throws IOException {
        short fieldCount = dis.readShort();
        classFile.fields = new Field[fieldCount];

        for (int i = 0; i < fieldCount; i++) {
            Field field = new Field();
            field.accessFlags = dis.readShort();
            field.nameIndex = dis.readShort();
            field.descriptionIndex = dis.readShort();
            field.attributes = readAttributes(classFile, dis);
            classFile.fields[i] = field;
        }
    }

    protected void loadInterfaces(ClassFile classFile, DataInputStream dis) throws IOException {
        short interfaceCount = dis.readShort();
        classFile.interfaces = new short[interfaceCount];
        for (int i = 0; i < interfaceCount; i++) {
            classFile.interfaces[i] = dis.readShort();
        }
    }

    protected void loadAccessFlags(ClassFile classFile, DataInputStream dis) throws IOException {
        classFile.accessFlags = dis.readShort();
    }

    protected void loadThisClassIndex(ClassFile classFile, DataInputStream dis) throws IOException {
        classFile.thisClassIndex = dis.readShort();
    }

    protected void loadSuperClassIndex(ClassFile classFile, DataInputStream dis) throws IOException {
        classFile.superClassIndex = dis.readShort();
    }

    protected void loadConstantPool(ClassFile classFile, DataInputStream dis) throws IOException {
        short constantCount = dis.readShort();
        classFile.constants = new Constant[constantCount];
        for (int i = 1; i < constantCount; i++) {
            int constantType = (int) dis.readByte();
            switch (constantType) {
                case 1: {
                    short stringLength = dis.readShort();
                    byte[] bytes = new byte[stringLength];
                    dis.read(bytes, 0, stringLength);
                    classFile.constants[i] = new ConstantUTF8(constantType, new String(bytes, StandardCharsets.UTF_8));
                    break;
                }
                case 3: {
                    classFile.constants[i] = new ConstantInteger(constantType, dis.readInt());
                    break;
                }
                case 4: {
                    System.out.println("ConstantType: " + constantType);
                    dis.readFloat();
                    break;
                }
                case 5: {
                    System.out.println("ConstantType: " + constantType);
                    dis.readLong();
                    break;
                }
                case 6: {
                    System.out.println("ConstantType: " + constantType);
                    dis.readDouble();
                    break;
                }
                case 7: {
                    classFile.constants[i] = new ConstantClass(constantType, dis.readShort());
                    break;
                }
                case 8: {
                    classFile.constants[i] = new ConstantString(constantType, dis.readShort());
                    break;
                }
                case 9: {
                    classFile.constants[i] = new ConstantFieldref(constantType, dis.readShort(), dis.readShort());
                    break;
                }
                case 10: {
                    classFile.constants[i] = new ConstantMethodref(constantType, dis.readShort(), dis.readShort());
                    break;
                }
                case 11: {
                    System.out.println("ConstantType: " + constantType);
                    dis.readInt();
                    break;
                }
                case 12: {
                    classFile.constants[i] = new ConstantNameAndType(constantType, dis.readShort(), dis.readShort());
                    break;
                }
                case 15: {
                    System.out.println("ConstantType: " + constantType);
                    dis.readShort();
                    dis.readByte();
                    break;
                }
                case 16: {
                    System.out.println("ConstantType: " + constantType);
                    dis.readByte();
                    break;
                }
                case 18: {
                    System.out.println("ConstantType: " + constantType);
                    dis.readInt();
                    break;
                }
                default:
                    throw new RuntimeException("Unknown constantType encountered: " + constantType);
            }
        }
    }

    protected boolean isJavaClassFile(DataInputStream dis) throws IOException {
        return dis.readByte() == (byte) 0xCA && dis.readByte() == (byte) 0xFE && dis.readByte() == (byte) 0xBA && dis.readByte() == (byte) 0xBE;
    }

    protected void loadVersion(ClassFile classFile, DataInputStream dis) throws IOException {
        classFile.minorVersion = dis.readShort();
        classFile.majorVersion = dis.readShort();
    }
}
