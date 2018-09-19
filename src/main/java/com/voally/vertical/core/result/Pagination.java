package com.voally.vertical.core.result;

import lombok.Data;

@Data
public class Pagination {

    private Integer prePage;

    private Integer nextPage;

    private Integer paginationPage;

    private Integer paginationSize;

    private Long paginationPageCount;

    private Integer[] paginationPageNums;
}
