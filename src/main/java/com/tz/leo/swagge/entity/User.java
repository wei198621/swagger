package com.tz.leo.swagge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Author: tz_wl
 * Date: 2020/7/16 20:57
 * Content:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)   //链式调用
public class User {
    private String id;
    private String name;
}
