# Install kubectl

## Windows

1. Download the latest release v1.14.0 from this link: https://storage.googleapis.com/kubernetes-release/release/v1.14.0/bin/windows/amd64/kubectl.exe

    Or if you have curl installed, use this command:

    curl -LO https://storage.googleapis.com/kubernetes-release/release/v1.14.0/bin/windows/amd64/kubectl.exe

2. Add the binary in to your PATH.

3. Test to ensure the version you installed is up-to-date:

    kubectl version

## Linux

1. Download the latest release v1.14.0 

    curl -LO https://storage.googleapis.com/kubernetes-release/release/v1.14.0/bin/linux/amd64/kubectl
    
2. Make the kubectl binary executable.

    chmod +x ./kubectl

3. Move the binary in to your PATH.

    sudo mv ./kubectl /usr/local/bin/kubectl

4. Test to ensure the version you installed is up-to-date:

    kubectl version

## Mac

1. Download the latest release v1.14.0 

    curl -LO https://storage.googleapis.com/kubernetes-release/release/v1.14.0/bin/darwin/amd64/kubectl
    
2. Make the kubectl binary executable.

    chmod +x ./kubectl

3. Move the binary in to your PATH.

    sudo mv ./kubectl /usr/local/bin/kubectl

4. Test to ensure the version you installed is up-to-date:

    kubectl version


## Official installation manual

    https://kubernetes.io/docs/tasks/tools/install-kubectl/

# Kubernetes files location
    src/kubernetes

# Create namespace 
1. Open file 00-namespace.yml
1. Define your own namespace by replacing `<namespace>`.
2. Create namespace: `kubectl apply -f 00-namespace.yml`

# Pods

## Deploy pod

`kubectl apply -f 01-pod.yml`

## Check pod status

`kubectl get pods -n <namespace>`

## Access your application via port forwarding

Application will be available on localhost:12345

`kubectl port-forward helloworld 12345:8080 -n <namespace>`

## Delete pod

`kubectl delete pod helloworld -n <namespace>`

# Services

## Deploy a service and access application via port forwarding to service

`kubectl port-forward service/helloworld-service 12345:8080 -n <namespace>`

# Deployment

## Scale a deployment 
`kubectl scale deployment/helloworld --replicas=3`

## Update a deployment with another image version

`kubectl set image -n <namespace> deployment/<deployment-name> <container-name>=<image>:<tag>`

`kubectl set image -n <namespace> deployment/helloworld helloworld=gcr.io/spot-ar/helloworld:6.0.0`

# ConfigMaps
## Dry run of creating config map from literal
`kubectl create configmap special-config --from-literal=special.how=very --dry-run -o yaml`

## Dry run of creating config map from file
`kubectl create configmap special-config --from-file=application.properties --dry-run -o yaml`

# Secrets
## Dry run of creating a secret 
`kubectl create secret generic db-user-pass --from-literal=username=user --from-literal=password=123456 -o yaml --dry-run`

# Access Dashboard

Start proxy
`kubectl proxy`

Open `localhost:8001/api/v1/namespaces/kube-system/services/https:kubernetes-dashboard:https/proxy/` in browser

Get Token

`kubectl -n kube-system describe secret $(kubectl -n kube-system get secret | grep admin-user | awk '{print $1}')`

Copy&paste token for authetication




