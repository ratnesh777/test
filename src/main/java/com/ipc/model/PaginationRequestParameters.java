package com.ipc.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import lombok.Data;

/**
 * Copyright (c) 2016 IPC Systems, Inc. Created by Viktor Bondarenko on 12/21/2016.
 */
@Data
public class PaginationRequestParameters
{
    @Min(value = 0)
    Integer page;
    @Min(value = 1)
    Integer size;
    @Pattern(regexp = "asc|desc|")
    String sortDirection;
    String searchKey;
}
