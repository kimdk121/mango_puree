package com.mangopuree.support.resttemplate;

import com.mangopuree.support.exception.CodeException;
import com.mangopuree.support.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.reflect.Field;
import java.net.URI;

@Slf4j
@Component
@RequiredArgsConstructor
public class RestTemplateHelper {

    private final RestTemplate restTemplate;

    public <T> T post(String url, Object body, ParameterizedTypeReference<T> responseType) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Object> request = new HttpEntity<>(body, headers);

        try {
            ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.POST, request, responseType);
            return response.getBody();
        } catch (ResourceAccessException ex) {
            log.error("[GET] API 타임아웃: url={}, body={}", url, body, ex);
            throw new CodeException(ErrorCode.API_TIMEOUT);
        } catch (RestClientException ex) {
            log.error("[GET] API 실패: url={}, body={}", url, body, ex);
            throw new CodeException(ErrorCode.API_FAIL);
        }
    }

    public <T> T get(String url, ParameterizedTypeReference<T> responseType) {

        try {
            ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.GET, null, responseType);
            return response.getBody();
        } catch (ResourceAccessException ex) {
            log.error("[GET] API 타임아웃: url={}", url, ex);
            throw new CodeException(ErrorCode.API_TIMEOUT);
        } catch (RestClientException ex) {
            log.error("[GET] API 실패: url={}", url, ex);
            throw new CodeException(ErrorCode.API_FAIL);
        }
    }

    public <T> T getWithParams(String url, Object dto, ParameterizedTypeReference<T> responseType) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);

        Field[] fields = dto.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(dto);
                if (value != null) {
                    builder.queryParam(field.getName(), value.toString());
                }
            } catch (IllegalAccessException e) {
                log.error("[GET] 파라미터 변환 실패: {}", field.getName(), e);
                throw new CodeException(ErrorCode.API_FAIL);
            }
        }
        URI uri = builder.build().encode().toUri();
        try {
            ResponseEntity<T> response = restTemplate.exchange(uri, HttpMethod.GET, null, responseType);
            return response.getBody();
        } catch (ResourceAccessException ex) {
            log.error("[GET] API 타임아웃: url={}", url, ex);
            throw new CodeException(ErrorCode.API_TIMEOUT);
        } catch (RestClientException ex) {
            log.error("[GET] API 실패: url={}", url, ex);
            throw new CodeException(ErrorCode.API_FAIL);
        }

    }
}
