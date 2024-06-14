
## 스크립트
``` 
spring boot cloud gateway 샘플프로젝트를 만들 건데 프로젝트 구성은 
 'root-project': 기본 루트 프로젝트
 'gateway' : 서비스를 조합해서 앤드유저에게 서비스 하기 위한 게이트웨이 서비스
 'member-service' : 회원정보를 조회 하는 api 서비스
 'permission-service', : 회원별 권한을 조회 하는 api 서비스
'product-service' : 물품 목록을 조회 하는 api 서비스 , 사용자 권한 별로 보여줄 수 있는 제품 다름

이고 gradle 로 root 아래 각 서브 모듈들이 있고 하며 spring boot 는 3.2.4 로 하고, 
개발툴은 intellij 를 쓸꺼고 
물품목록을 조회 할때 회원정보를 확인하여 여부를 보고 그에 따른 권한을 확인 한후 가능한 품목만 보여주는 샘플 만들었으면 좋겠어. 

gradle로  프로젝트 구성에  스크립트를 작성하고 
기동하면 3개의 api  서비스가 각 포트로 기동하고  gateway를 통해서 3개의 서비스를 로직에 맞게 접속해서 최종 결과를 주는 api 서비스가 되면 될 거 같아.
```

## gateway 
### gate 역활 
 - 사용자 호출 진입점.
 - 외부 노출됨
### gateway URL
- http://localhost:8080/api/products?memberId=1

-- 

## Product Service
### Product Service 역활
- 특정 사용자에게 특정 제품정보 제공
- 외부 노출 되지 않음

### Product URL
- http://localhost:8083 

## Member Service
- http://localhost:8081

## Permission Service
- http://localhost:8082

