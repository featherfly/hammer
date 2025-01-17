
package cn.featherfly.hammer.tpl.mapper;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Arrays;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.util.TraceClassVisitor;

import cn.featherfly.common.lang.ClassLoaderUtils;
import cn.featherfly.common.lang.ClassUtils;

/**
 * <p>
 * T
 * </p>
 *
 * @author zhongj
 */
public class Subclass extends Superclass<User> {

    public static void main(String[] args) throws IOException {
        //        ClassReader classReader = new ClassReader(T.class.getName());
        ClassReader classReader = new ClassReader(
                ClassLoaderUtils.getResourceAsStream(ClassUtils.packageToFile(BasedTplGenericHammer.class)));
        //        classReader.accept(new ClassVisitor(Opcodes.ASM9) {
        //
        //            @Override
        //            public MethodVisitor visitMethod(final int access, final String name, final String descriptor,
        //                    final String signature, final String[] exceptions) {
        //                System.out.println(name + " " + descriptor);
        //                System.out.println("method.signature " + signature);
        //                return super.visitMethod(access, name, descriptor, signature, exceptions);
        //            }
        //
        //            @Override
        //            public void visitAttribute(final Attribute attribute) {
        //                super.visitAttribute(attribute);
        //                System.out.println("attribute.type " + attribute.type);
        //            }
        //
        //            @Override
        //            public void visitSource(final String source, final String debug) {
        //                super.visitSource(source, debug);
        //                System.out.println(Str.format("source {0} debug {1}", source, debug));
        //            }
        //        }, ClassReader.EXPAND_FRAMES);

        classReader.accept(new TraceClassVisitor(new ClassVisitor(Opcodes.ASM9) {
            {
            }
        }, new PrintWriter(System.out)), ClassReader.SKIP_DEBUG);

        System.out.println("-----");
        System.out.println(classReader.getClassName());
        System.out.println(Arrays.toString(classReader.getInterfaces()));
        System.out.println(classReader.getSuperName());
        System.out.println(classReader.getAccess());

        TraceClassVisitor traceClassVisitor = new TraceClassVisitor(new ClassVisitor(Opcodes.ASM9) {
            {
            }
        }, new PrintWriter(System.out));

        System.out.println(traceClassVisitor);
        //        ASMifier asm = new ASMifier();
    }

    @Override
    public User get(Serializable id) {
        return super.get(id);
    }
}
