
package cn.featherfly.hammer.tpl.mapper;

import java.util.Map;

import org.objectweb.asm.Type;

import cn.featherfly.common.lang.ArrayUtils;
import cn.featherfly.common.structure.ChainMap;
import cn.featherfly.hammer.Hammer;
import cn.featherfly.hammer.tpl.TplExecuteId;

/**
 * <p>
 * User
 * </p>
 *
 * @author zhongj
 */
public class User {

    public void set(String name) {

    }

    public static void main(String[] args) throws NoSuchMethodException, SecurityException {
        System.out.println(ArrayUtils.toString(ChainMap.class.getDeclaredMethods()));
        System.out.println(ChainMap.class.getMethod("putChain", Object.class, Object.class));

        System.out.println(Hammer.class.getMethod("execute", TplExecuteId.class, Map.class));
        System.out.println(Hammer.class.getMethod("intValue", TplExecuteId.class, Map.class));
        System.out.println(Hammer.class.getMethod("longValue", TplExecuteId.class, Map.class));
        System.out.println(Hammer.class.getMethod("longValue", TplExecuteId.class, Map.class));

        System.out.println(
                ByteCodeUtils.getConstructorDescriptor(String.class, String.class, Class.class, boolean.class));
        System.out.println(Type.getDescriptor(boolean.class));
        System.out.println(Type.getDescriptor(String.class));
        System.out.println(Type.getDescriptor(Object.class));

    }
}
