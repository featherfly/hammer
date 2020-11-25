
package cn.featherfly.hammer.tpl.mapper;

import static org.objectweb.asm.Opcodes.ALOAD;
import static org.objectweb.asm.Opcodes.ARETURN;
import static org.objectweb.asm.Opcodes.DLOAD;
import static org.objectweb.asm.Opcodes.DRETURN;
import static org.objectweb.asm.Opcodes.FLOAD;
import static org.objectweb.asm.Opcodes.FRETURN;
import static org.objectweb.asm.Opcodes.ILOAD;
import static org.objectweb.asm.Opcodes.IRETURN;
import static org.objectweb.asm.Opcodes.LLOAD;
import static org.objectweb.asm.Opcodes.LRETURN;
import static org.objectweb.asm.Opcodes.RETURN;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.TypeInsnNode;
import org.objectweb.asm.tree.VarInsnNode;

import cn.featherfly.common.lang.ClassUtils;
import cn.featherfly.common.lang.Lang;
import cn.featherfly.common.lang.Strings;

/**
 * <p>
 * AsmUtils
 * </p>
 * .
 *
 * @author zhongj
 */
public class ByteCodeUtils {

    private static final int SPACE_LEN = 20;

    /** The Constant CONSTRUCT_METHOD. */
    public static final String CONSTRUCT_METHOD = "<init>";

    /** The Constant PRIMITIVE_WRAPPER_METHOD. */
    public static final String PRIMITIVE_WRAPPER_METHOD = "valueOf";

    /** The Constant NONE_PARAMETER_DESCRIPTOR. */
    public static final String NONE_PARAMETER_DESCRIPTOR = "()V";

    /** The Constant OPCODE_MAP. */
    public static final Map<Integer, String> OPCODE_MAP = new HashMap<>();

    /** The Constant PRIMITIVE_WRAPPER_METHOD_DESCRIPTOR. */
    public static final Map<Class<?>, String> PRIMITIVE_WRAPPER_METHOD_DESCRIPTOR = new HashMap<>();

    /** The Constant PRIMITIVE_WRAPPER. */
    public static final Map<Class<?>, Class<?>> PRIMITIVE_WRAPPER = new HashMap<>();

    /** The Constant WRAPPER_PRIMITIVE. */
    public static final Map<Class<?>, Class<?>> WRAPPER_PRIMITIVE = new HashMap<>();

    static {
        boolean start = false;
        for (Field field : Opcodes.class.getFields()) {
            if (field.getName().equals("NOP")) {
                start = true;
            }
            if (start) {
                Integer value = (Integer) ClassUtils.getFieldValue(Opcodes.class, field.getName());
                OPCODE_MAP.put(value, field.getName().toLowerCase());
            }
        }

        String valueOf = "valueOf";
        PRIMITIVE_WRAPPER_METHOD_DESCRIPTOR.put(Boolean.TYPE,
                Type.getMethodDescriptor(ClassUtils.getMethod(Boolean.class, valueOf, Boolean.TYPE)));
        PRIMITIVE_WRAPPER_METHOD_DESCRIPTOR.put(Character.TYPE,
                Type.getMethodDescriptor(ClassUtils.getMethod(Character.class, valueOf, Character.TYPE)));
        PRIMITIVE_WRAPPER_METHOD_DESCRIPTOR.put(Byte.TYPE,
                Type.getMethodDescriptor(ClassUtils.getMethod(Byte.class, valueOf, Byte.TYPE)));
        PRIMITIVE_WRAPPER_METHOD_DESCRIPTOR.put(Short.TYPE,
                Type.getMethodDescriptor(ClassUtils.getMethod(Short.class, valueOf, Short.TYPE)));
        PRIMITIVE_WRAPPER_METHOD_DESCRIPTOR.put(Integer.TYPE,
                Type.getMethodDescriptor(ClassUtils.getMethod(Integer.class, valueOf, Integer.TYPE)));
        PRIMITIVE_WRAPPER_METHOD_DESCRIPTOR.put(Long.TYPE,
                Type.getMethodDescriptor(ClassUtils.getMethod(Long.class, valueOf, Long.TYPE)));
        PRIMITIVE_WRAPPER_METHOD_DESCRIPTOR.put(Float.TYPE,
                Type.getMethodDescriptor(ClassUtils.getMethod(Float.class, valueOf, Float.TYPE)));
        PRIMITIVE_WRAPPER_METHOD_DESCRIPTOR.put(Double.TYPE,
                Type.getMethodDescriptor(ClassUtils.getMethod(Double.class, valueOf, Double.TYPE)));

        PRIMITIVE_WRAPPER.put(Boolean.TYPE, Boolean.class);
        PRIMITIVE_WRAPPER.put(Character.TYPE, Character.class);
        PRIMITIVE_WRAPPER.put(Byte.TYPE, Byte.class);
        PRIMITIVE_WRAPPER.put(Short.TYPE, Short.class);
        PRIMITIVE_WRAPPER.put(Integer.TYPE, Integer.class);
        PRIMITIVE_WRAPPER.put(Long.TYPE, Long.class);
        PRIMITIVE_WRAPPER.put(Float.TYPE, Float.class);
        PRIMITIVE_WRAPPER.put(Double.TYPE, Double.class);
        PRIMITIVE_WRAPPER.put(Void.TYPE, Void.class);

        WRAPPER_PRIMITIVE.put(Boolean.class, Boolean.TYPE);
        WRAPPER_PRIMITIVE.put(Character.class, Character.TYPE);
        WRAPPER_PRIMITIVE.put(Byte.class, Byte.TYPE);
        WRAPPER_PRIMITIVE.put(Short.class, Short.TYPE);
        WRAPPER_PRIMITIVE.put(Integer.class, Integer.TYPE);
        WRAPPER_PRIMITIVE.put(Long.class, Long.TYPE);
        WRAPPER_PRIMITIVE.put(Float.class, Float.TYPE);
        WRAPPER_PRIMITIVE.put(Double.class, Double.TYPE);
        WRAPPER_PRIMITIVE.put(Void.class, Void.TYPE);
    }

    /**
     * Opcode name.
     *
     * @param opcode the opcode
     * @return the string
     */
    public static String opcodeName(int opcode) {
        return opcodeName(opcode, false);
    }

    private static String opcodeName(int opcode, boolean appendSpace) {
        String result = OPCODE_MAP.get(opcode);
        if (result == null) {
            result = opcode + "";
        }
        if (appendSpace) {
            int appendSize = SPACE_LEN - result.length();
            for (int i = 0; i < appendSize; i++) {
                result += " ";
            }
        }
        return result;
    }

    /**
     * Javap string.
     *
     * @param abstractInsnNode the abstract insn node
     * @return the string
     */
    public static String javapString(AbstractInsnNode abstractInsnNode) {
        if (abstractInsnNode instanceof VarInsnNode) {
            VarInsnNode node = (VarInsnNode) abstractInsnNode;
            return opcodeName(node.getOpcode()) + "_" + node.var;
        } else if (abstractInsnNode instanceof FieldInsnNode) {
            FieldInsnNode node = (FieldInsnNode) abstractInsnNode;
            return opcodeName(node.getOpcode(), true) + "// Field " + node.name + ":" + node.desc;
        } else if (abstractInsnNode instanceof TypeInsnNode) {
            TypeInsnNode node = (TypeInsnNode) abstractInsnNode;
            return opcodeName(node.getOpcode(), true) + "// class " + node.desc;
        } else if (abstractInsnNode instanceof InsnNode) {
            InsnNode node = (InsnNode) abstractInsnNode;
            return opcodeName(node.getOpcode());
        } else if (abstractInsnNode instanceof LdcInsnNode) {
            LdcInsnNode node = (LdcInsnNode) abstractInsnNode;
            return opcodeName(node.getOpcode(), true) + "// " + node.cst.getClass().getSimpleName() + " " + node.cst;
        } else if (abstractInsnNode instanceof MethodInsnNode) {
            MethodInsnNode node = (MethodInsnNode) abstractInsnNode;
            if (node.itf) {
                return opcodeName(node.getOpcode(), true) + "// InterfaceMethod " + node.owner + "." + node.name + ":"
                        + node.desc;
            } else {
                return opcodeName(node.getOpcode(), true) + "// Method " + node.owner + "." + node.name + ":"
                        + node.desc;
            }
        }
        return abstractInsnNode.getClass().getName() + " " + opcodeName(abstractInsnNode.getOpcode()) + " "
                + abstractInsnNode.getOpcode();
    }

    /**
     * Gets the method descriptor.
     *
     * @param type the type
     * @return the string
     */
    public static String _getMethodDescriptor(Class<?> type) {
        return Type.getDescriptor(type);
    }

    /**
     * Gets the constructor descriptor.
     *
     * @param paramTypes the param types
     * @return the constructor descriptor
     */
    public static String getConstructorDescriptor(Class<?>... paramTypes) {
        if (Lang.isEmpty(paramTypes)) {
            return NONE_PARAMETER_DESCRIPTOR;
        }
        StringBuilder params = new StringBuilder();
        for (Class<?> type : paramTypes) {
            params.append(_getMethodDescriptor(type));
        }
        return Strings.format("({0})V", params.toString());
    }

    /**
     * Gets the name.
     *
     * @param type the type
     * @return the name
     */
    public static String getName(Class<?> type) {
        return getName(type.getName());
    }

    /**
     * Gets the name.
     *
     * @param className the class name
     * @return the name
     */
    public static String getName(String className) {
        return className.replace('.', '/');
    }

    /**
     * Gets the return code.
     *
     * @param type the type
     * @return the return code
     */
    public static int getReturnCode(Class<?> type) {
        if (type.isPrimitive()) {
            return getPrimitiveReturnCode(type);
        } else {
            return ARETURN;
        }
    }

    /**
     * Gets the primitive return code.
     *
     * @param primitiveType the primitive type
     * @return the primitive return code
     */
    public static int getPrimitiveReturnCode(Class<?> primitiveType) {
        if (primitiveType == Integer.TYPE) {
            return IRETURN;
        } else if (primitiveType == Byte.TYPE) {
            return IRETURN;
        } else if (primitiveType == Short.TYPE) {
            return IRETURN;
        } else if (primitiveType == Character.TYPE) {
            return IRETURN;
        } else if (primitiveType == Boolean.TYPE) {
            return IRETURN;
        } else if (primitiveType == Long.TYPE) {
            return LRETURN;
        } else if (primitiveType == Double.TYPE) {
            return DRETURN;
        } else if (primitiveType == Float.TYPE) {
            return FRETURN;
        } else {
            return RETURN;
        }
    }

    /**
     * Gets the primitive return code.
     *
     * @param primitiveType the primitive type
     * @return the primitive return code
     */
    public static int getLoadCode(Class<?> primitiveType) {
        if (primitiveType == Integer.TYPE) {
            return ILOAD;
        } else if (primitiveType == Byte.TYPE) {
            return ILOAD;
        } else if (primitiveType == Short.TYPE) {
            return ILOAD;
        } else if (primitiveType == Character.TYPE) {
            return ILOAD;
        } else if (primitiveType == Boolean.TYPE) {
            return ILOAD;
        } else if (primitiveType == Long.TYPE) {
            return LLOAD;
        } else if (primitiveType == Double.TYPE) {
            return DLOAD;
        } else if (primitiveType == Float.TYPE) {
            return FLOAD;
        } else {
            return ALOAD;
        }
    }

    /**
     * Gets the primitive wrapper method descriptor.
     *
     * @param type the type
     * @return the primitive wrapper method descriptor
     */
    public static String getPrimitiveWrapperMethodDescriptor(Class<?> type) {
        return PRIMITIVE_WRAPPER_METHOD_DESCRIPTOR.get(type);
    }

    /**
     * Gets the primitive wrapper name.
     *
     * @param type the type
     * @return the primitive wrapper name
     */
    public static String getPrimitiveWrapperName(Class<?> type) {
        if (type.isPrimitive()) {
            return Type.getInternalName(PRIMITIVE_WRAPPER.get(type));
        } else {
            return Type.getInternalName(type);
        }
    }
}
