# Optimizing Cloud Native Java - ko

'클라우드 기반 자바 최적화' 한국어 번역판의 샘플 코드입니다.
<p align="center">
<img src="https://github.com/user-attachments/assets/d746a56d-28a7-4bf3-9e9d-a0e4467db9a8" width="50%">

## 1. 준비사항
- JDK 17과 21을 기반으로 진행합니다.
- mvn, docker, docker-compose 가 필요합니다.
- 원저자가 제공하는 git
  * animals-demo : https://github.com/kittylyst/fighting-animals.git
  * fighting-animals-hospital : https://github.com/kittylyst/fighting-animals-hospital.git
  
## 2. 목차별 branch map
#### animals-demo
- 9.1, 9.1.1, 9.1.2 : main
- 9.2.1, 9.2.4, 9.2.5, 9.3.2
- 10.2.2 : logging_only
- 11.1.1, 11.1.2, 11.1.3, 11.1.5, 11.1.6 : micrometer_only
- 11.1.7, 11.2.2: micrometer_with_prom
- 11.4.1 : manual_tracing
- 11.5 : otel_metrics_raw_api
- 11.6 : logging_only
- 14.4.1 : distributed_systems
- 14.4.3 : with_infinispan
  
#### fighting-animals-hospital
- 14.4.2 : listen_and_log
- 14.4.3 : with_infinispan


