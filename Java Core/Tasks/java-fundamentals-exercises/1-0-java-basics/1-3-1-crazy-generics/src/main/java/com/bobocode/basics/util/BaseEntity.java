package com.bobocode.basics.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity {
    protected UUID uuid;
    protected LocalDateTime createdOn;

    public BaseEntity(UUID uuid) {
        this.uuid = uuid;
        this.createdOn = LocalDateTime.now();
    }
}
