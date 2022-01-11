package com.tqi_evolution_backend_2021.analisecred.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LoginClientDTO {
    public String email;
    public String senha;
}
