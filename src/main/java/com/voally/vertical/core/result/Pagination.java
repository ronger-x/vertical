package com.voally.vertical.core.result;

import lombok.Data;

@Data
public class Pagination {

    private Integer paginationPage;

    private Integer paginationRows;

    private Long paginationPageCount;

    private Integer[] paginationPageNums;
}
