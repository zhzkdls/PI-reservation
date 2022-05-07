package com.yeyac.tb_facit.controller;

import com.yeyac.tb_facit.service.Tb_facitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/tacit")
public class Tb_facitAPIController {

    private final Tb_facitService tbFacitService;

    @GetMapping("/fillFacit")
    public void callApi() throws IOException {

        /*URL*/
        String result = "http://www.kspo.or.kr/openapi/service/sportsFacilInfoService/getFacilInfoList" +
                "?" + URLEncoder.encode("serviceKey", StandardCharsets.UTF_8) +
                "=dm6F81mVijVHy%2BroR8u3V813gEg%2Fgeszi%2BdeGiDSiyLB0aOelsfRV%2F910V8QTVRknuLXxi7%2B%2BrnJn21iT%2F%2BMgA%3D%3D" + /*Service Key*/
                "&" + URLEncoder.encode("pageNo", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("1", StandardCharsets.UTF_8) + /*페이지번호*/
                "&" + URLEncoder.encode("numOfRows", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("1200", StandardCharsets.UTF_8) + /*한 페이지 결과 수*/
                "&" + URLEncoder.encode("faciGbNm", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("공공", StandardCharsets.UTF_8) + /*시설구분명*/
                "&" + URLEncoder.encode("fmngCpNm", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("부산", StandardCharsets.UTF_8); /*시설유형명*/

        URL url = new URL(result + "&_type=json" );

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");

        BufferedReader br;

        br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            sb.append(line).append("\n\r");
        }
        br.close();
        conn.disconnect();

        tbFacitService.init(sb.toString());
    }

    @GetMapping("/getapi")
    public String getAPI() throws IOException {
        /*URL*/
        String result = "http://www.kspo.or.kr/openapi/service/sportsFacilInfoService/getFacilInfoList" +
                "?" + URLEncoder.encode("serviceKey", StandardCharsets.UTF_8) +
                "=dm6F81mVijVHy%2BroR8u3V813gEg%2Fgeszi%2BdeGiDSiyLB0aOelsfRV%2F910V8QTVRknuLXxi7%2B%2BrnJn21iT%2F%2BMgA%3D%3D" + /*Service Key*/
                "&" + URLEncoder.encode("pageNo", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("1", StandardCharsets.UTF_8) + /*페이지번호*/
                "&" + URLEncoder.encode("numOfRows", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("10", StandardCharsets.UTF_8) + /*한 페이지 결과 수*/
                "&" + URLEncoder.encode("faciGbNm", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("공공", StandardCharsets.UTF_8) + /*시설구분명*/
                "&" + URLEncoder.encode("fmngCpNm", StandardCharsets.UTF_8) + "=" + URLEncoder.encode("부산", StandardCharsets.UTF_8); /*시설유형명*/

        URL url = new URL(result + "&_type=json" );

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");

        BufferedReader br;

        br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            sb.append(line).append("\n\r");
        }
        br.close();
        conn.disconnect();

        return sb.toString();
    }
}
