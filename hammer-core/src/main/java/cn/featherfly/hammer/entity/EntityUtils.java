
/*
 * All rights Reserved, Designed By zhongj
 * @Description:
 * @author: zhongj
 * @date: 2025-12-21 23:55:21
 * @Copyright: 2025 www.featherfly.cn Inc. All rights reserved.
 */
package cn.featherfly.hammer.entity;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.core.type.classreading.MetadataReader;

import cn.featherfly.common.lang.Lang;

/**
 * EntityUtils.
 *
 * @author zhongj
 */
public class EntityUtils {

    private static final Set<String> ANNOTATION_TYPES = Lang.set("javax.persistence.Entity", "javax.persistence.Table",
        "jakarta.persistence.Entity", "jakarta.persistence.Table");

    /**
     * Checks if is entity.
     *
     * @param type the type
     * @return true, if is entity
     */
    public static boolean isEntity(Class<?> type) {
        final Set<String> names = Arrays.stream(type.getAnnotations()).map(a -> a.annotationType().getName())
            .collect(Collectors.toSet());
        return ANNOTATION_TYPES.stream().anyMatch(at -> names.contains(at));
    }

    /**
     * Checks if is entity.
     *
     * @param metadataReader the metadata reader
     * @return true, if is entity
     */
    public static boolean isEntity(MetadataReader metadataReader) {
        return ANNOTATION_TYPES.stream().anyMatch(at -> metadataReader.getAnnotationMetadata().hasAnnotation(at));
    }

}
