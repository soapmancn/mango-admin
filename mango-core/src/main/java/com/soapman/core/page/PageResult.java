package com.soapman.core.page;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult {
    private int pageNum;
    private int pageSize;
    private long totalSize;
    private int totalPages;
    private List<?> content;
}
