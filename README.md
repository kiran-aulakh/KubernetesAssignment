Kubernetes Assignment

Assignment to integrate user microservice with MYSQL database in kubernetes cluster and all microservices reporting to 
Jaegar service running on GKE cluster.

Prerequisite :
Docker 
Kubernetes command-line tool(kubectl)
Java
Maven

Start application:
1. Config for jaegar url
  kubectl apply -f url-config-jaegar.yml
2. Create secret for MYSQL database
  kubectl create secret generic my-db-pass --from-literal password=password
3. Create Jaeger service
  kubectl create -f https://raw.githubusercontent.com/jaegertracing/jaeger-kubernetes/master/all-in-one/jaeger-all-in-one-template.yml
4. Deploy orders microservice
  kubectl apply -f order-service-deployment.yaml
5. Expose order microservice internally using kubernetes clusterIP service
  kubectl apply -f orders-service.yml
6. Deploy MYSQL as stateful set to persist state of SQL data
  kubectl apply -f mysql-statefulset-deployment.yml
7. Headless service for MYSQL
  kubectl apply -f mysql-headless-service.yml
8. Deploy users microservice
  kubectl apply -f user-microservice-deployment.yaml 
9. Expose users microservice internally using kubernetes clusterIP service
  kubectl apply -f users-service.yml
10. Deploy aggregator microservice
  kubectl apply -f aggregator-microservice-deployment.yaml
11. Expose aggregator microservice externally using LoadBalancer service
  kubectl apply -f aggregator-service.yml
  
  
  
  
  
  
