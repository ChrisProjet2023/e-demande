package net.app.gesformationservice.clients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "PERSONNEL-SERVICE")
public interface PersonnelRestClient {
}
