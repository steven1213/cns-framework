package com.steven.cns.minio.spring.boot.starter;

import org.springframework.cloud.commons.util.SpringFactoryImportSelector;

/**
 * @author: steven
 * @date: 2023/7/7 21:45
 */
public class EnableCnsMinIOImportSelector extends SpringFactoryImportSelector {
    @Override
    protected boolean isEnabled() {
        return false;
    }
}
