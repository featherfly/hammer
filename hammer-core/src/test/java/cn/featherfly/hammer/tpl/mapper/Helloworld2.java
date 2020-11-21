package cn.featherfly.hammer.tpl.mapper;

import java.io.FileOutputStream;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.signature.SignatureVisitor;
import org.objectweb.asm.signature.SignatureWriter;

import cn.featherfly.common.lang.ClassUtils;

public class Helloworld2 extends ClassLoader implements Opcodes {

    public static void main(final String args[]) throws Exception {
        String name = "cn.featherfly.Example2";
        //定义一个叫做Example2的类
        String superClass = Type.getInternalName(Superclass.class);

        String superClassGenericType = Type.getInternalName(User.class);

        ClassWriter cw = new ClassWriter(0);

        SignatureWriter signature = new SignatureWriter();
        SignatureVisitor superVisitor = signature.visitSuperclass();
        superVisitor.visitClassType(superClass);
        SignatureVisitor typeVisitor = superVisitor.visitTypeArgument(SignatureVisitor.INSTANCEOF);
        //        typeVisitor.visitTypeVariable(Type.getInternalName(User.class));
        typeVisitor.visitClassType(superClassGenericType);
        typeVisitor.visitEnd();
        //        superVisitor.visitTypeArgument();
        //        superVisitor.visitClassBound().visitFormalTypeParameter(superClassGenericType);
        //        superVisitor.visitTypeArgument(SignatureVisitor.INSTANCEOF);
        //                superVisitor.visitTypeVariable(ByteCodeUtils.getName(User.class));
        //        superVisitor.visitFormalTypeParameter(ByteCodeUtils.getName(User.class));
        //        superVisitor.visitFormalTypeParameter(superClassGenericType);
        //        superVisitor.visitTypeVariable(Type.getInternalName(User.class));
        //                superVisitor.visitTypeVariable(String.class.getName());
        //        SignatureVisitor classBound = superVisitor.visitClassBound();
        //        classBound.visitClassType(superClass);
        //        classBound.visitFormalTypeParameter(superClassGenericType);
        //        classBound.visitEnd();
        //        visitor.visitClassBound().visitTypeVariable(String.class.getName());
        //        visitor.visitTypeVariable(Type.getInternalName(String.class));

        // signature Lcn/featherfly/hammer/tpl/mapper/Superclass<Lcn/featherfly/hammer/tpl/mapper/User;>;

        superVisitor.visitEnd();

        //        cw.visit(V1_8, ACC_PUBLIC, ByteCodeUtils.getName(name), null, superClass, null);
        System.out.println(signature.toString());
        cw.visit(V1_8, ACC_PUBLIC, ByteCodeUtils.getName(name),
                "Lcn/featherfly/hammer/tpl/mapper/Superclass<Lcn/featherfly/hammer/tpl/mapper/User;>;", superClass,
                null);

        //        visitor.visitClassType(Type.getInternalName(BasedTplGenericHammer.class));

        //生成默认的构造方法
        MethodVisitor mw = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
        //生成构造方法的字节码指令
        mw.visitVarInsn(ALOAD, 0);
        mw.visitMethodInsn(INVOKESPECIAL, superClass, "<init>", "()V", false);
        //        mw.visitMethodInsn(INVOKESPECIAL, superClass, "<init>", "(Ljava/lang/String;)V", false);
        mw.visitInsn(RETURN);
        mw.visitMaxs(1, 1);
        mw.visitEnd();

        MethodVisitor mw2 = cw.visitMethod(ACC_PUBLIC, "<init>", "(Ljava/lang/String;)V", null, null);
        mw2.visitVarInsn(ALOAD, 0);
        mw2.visitVarInsn(ALOAD, 1);
        mw2.visitMethodInsn(INVOKESPECIAL, superClass, "<init>", "(Ljava/lang/String;)V", false);
        mw2.visitInsn(RETURN);
        mw2.visitMaxs(2, 2);
        mw2.visitEnd();

        String getDesc = "(Ljava/io/Serializable;)" + Type.getDescriptor(User.class);
        MethodVisitor get = cw.visitMethod(ACC_PUBLIC, "get", getDesc, null, null);
        get.visitVarInsn(ALOAD, 0);
        get.visitVarInsn(ALOAD, 1);
        get.visitMethodInsn(INVOKESPECIAL, superClass, "get", getDesc, false);
        //        get.visitMethodInsn(INVOKESPECIAL, superClass, "<init>", "(Ljava/lang/String;)V", false);
        get.visitInsn(ARETURN);
        get.visitMaxs(2, 2);
        get.visitEnd();

        //生成main方法
        mw = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);

        //生成main方法中的字节码指令
        mw.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mw.visitLdcInsn("Hello world!");
        mw.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        mw.visitInsn(RETURN);
        mw.visitMaxs(2, 2);

        //字节码生成完成
        mw.visitEnd();

        // 获取生成的class文件对应的二进制流
        byte[] code = cw.toByteArray();

        //将二进制流写到本地磁盘上
        FileOutputStream fos = new FileOutputStream("Example2.class");
        fos.write(code);
        fos.close();

        //直接将二进制流加载到内存中
        Helloworld2 loader = new Helloworld2();
        Class<?> exampleClass = loader.defineClass(name, code, 0, code.length);

        //通过反射调用main方法
        exampleClass.getMethods()[0].invoke(null, new Object[] { null });

        Object target = ClassUtils.newInstance(exampleClass);

        //        ClassUtils.invokeMethod(target, "get", 1);
        System.out.println(ClassUtils.getSuperClassGenricType(exampleClass));
    }
}
