# spring.integration.dls

Spring tcp server
 
## 기본 구성
springboot 2.4.5 + spring-integration 5.4.6 + jpa 

## 참고소스

https://github.com/spring-projects/spring-integration-samples/blob/main/intermediate/tcp-client-server-multiplex

- 기존 xml로 된 것을 java code로 변경
- jps 연동
- 승인/중계 서버에 맞게 구조만 맞춤
-> 상황에 따라 factory라 던가 extendhandler 계속 추가 해야함(요구사항은 계속 바뀜)


## 주절주절

spring-integration 의 핵심은 SubscribeChannel !?

구독 등록 -> 등록된 user에 전파

firebase fcm, websocket 등등...

