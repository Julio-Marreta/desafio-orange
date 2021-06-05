package com.example.desafioorange.veiculo.integracao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "${fipe.feign.name}", url = "${fipe.feign.url}")
public interface FipeFeign {

    @GetMapping("/carros/marcas")
    List<Marca> getMarcas();

    @GetMapping("/carros/marcas/{id}/modelos")
    Modelos getModelos(@PathVariable String id);

    @GetMapping("/carros/marcas/{idMarca}/modelos/{idModelo}/anos")
    List<Veiculo> getAnos(@PathVariable String idMarca, @PathVariable Integer idModelo);

    @GetMapping("/carros/marcas/{idMarca}/modelos/{idModelo}/anos/{ano}")
    DetalheVeiculo getDetalhes(@PathVariable String idMarca, @PathVariable Integer idModelo, @PathVariable String ano);
}
