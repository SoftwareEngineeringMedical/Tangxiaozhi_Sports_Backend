package edu.tongji.backend.dto;

/*-
 * #%L
 * Tangxiaozhi
 * %%
 * Copyright (C) 2024 All contributors of the project
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */





import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Boolean success;
    private String errorMsg;
    private Object data;
    private Long total;
    public static Result ok(){
        return new Result(true,null,null,null);
    }
    public static Result ok(Object data){
        return new Result(true,null,data,null);
    }
    public static Result ok(List<?> data, Long total){
        return new Result(true,null,data,total);
    }
    public static Result fail(String errorMsg){
        return new Result(false,errorMsg,null,null);
    }
}
