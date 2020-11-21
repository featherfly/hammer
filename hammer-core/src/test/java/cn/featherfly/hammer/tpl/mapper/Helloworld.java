package cn.featherfly.hammer.tpl.mapper;

import java.io.FileOutputStream;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class Helloworld extends ClassLoader implements Opcodes {

    public static void main(final String args[]) throws Exception {

        String name = "cn.featherfly.Example";

        //定义一个叫做Example的类
        ClassWriter cw = new ClassWriter(0);
        cw.visit(V1_8, ACC_PUBLIC, ByteCodeUtils.getName(name), null, "java/lang/Object", null);

        //生成默认的构造方法
        MethodVisitor mw = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);

        //生成构造方法的字节码指令
        mw.visitVarInsn(ALOAD, 0);
        mw.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        mw.visitInsn(RETURN);
        mw.visitMaxs(1, 1);
        mw.visitEnd();

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
        FileOutputStream fos = new FileOutputStream("Example.class");
        fos.write(code);
        fos.close();

        //直接将二进制流加载到内存中
        Helloworld loader = new Helloworld();
        Class<?> exampleClass = loader.defineClass(name, code, 0, code.length);

        //通过反射调用main方法
        exampleClass.getMethods()[0].invoke(null, new Object[] { null });

    }
}
