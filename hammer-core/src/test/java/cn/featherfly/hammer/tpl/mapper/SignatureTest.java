
package cn.featherfly.hammer.tpl.mapper;

import org.objectweb.asm.Type;
import org.objectweb.asm.signature.SignatureVisitor;
import org.objectweb.asm.signature.SignatureWriter;

import cn.featherfly.common.asm.Asm;

/**
 * <p>
 * Sig
 * </p>
 *
 * @author zhongj
 */
public class SignatureTest {
    public static void main(String[] args) {
        String superClass = Asm.getName(Superclass.class);
        String superClassGenericType = Type.getInternalName(User.class);

        System.out.println(superClass);
        System.out.println(superClassGenericType);

        SignatureWriter signature = new SignatureWriter();
        SignatureVisitor superVisitor = signature.visitSuperclass();
        superVisitor.visitClassType(superClass);

        //        SignatureVisitor parameter = superVisitor.visitParameterType();
        //        parameter.visitTypeArgument(SignatureVisitor.INSTANCEOF);
        //        parameter.visitTypeVariable(Type.getInternalName(User.class));
        //        parameter.visitEnd();

        SignatureVisitor typeVisitor = superVisitor.visitTypeArgument(SignatureVisitor.INSTANCEOF);
        //        typeVisitor.visitTypeVariable(superClassGenericType);
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

        System.out.println(signature.toString());
    }
}
