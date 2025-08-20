# Kubernetes Configuration for Deploying airtasker-demo App

## Cluster Setup

1. Install k3s https://docs.k3s.io/installation with default settings.  
   By default k3s has `traefik` installed as ingress controller and `Service LB` as load balancer.
2. [Optional] for prod environment.  
   a. Install [cert-manager](https://cert-manager.io/) and configure ClusterIssuer with proper secrets.  
   The example `prod` env is using [Cloudflare](https://cert-manager.io/docs/configuration/acme/dns01/cloudflare/).  
   b. If you're using a different hostname than `airtasker.chris-nie.com`, please update the hostname in `./overlays/prod/traefik_ingress.yml`

## Usage

### Deploy with Default Settings

```bash
# Apply the default overlay
kubectl apply -k overlays/default

# Wait for the deployment to become ready
kubectl get deploy -n airtasker-chris-default -w

# Get the External IP address
kubectl get svc -n airtasker-chris-default

# Validate the deployment
# Replace <external-ip> with the actual IP address
curl http://<external-ip>:8080/_health
```

### Check the App in Production Environment

> **Note:** The production environment requires several resources to be pre-configured in the cluster.

The app is deployed at: [https://airtasker.chris-nie.com](https://airtasker.chris-nie.com)

```bash
# Please check your cluster has installed the following dependencies
# 1. Traefik is installed as ingress controller
# 2. Load balancer is configured (the example uses Service LB)
# 3. cert-manager and a valid production ClusterIssuer
# 4. The hostname is updated to a hostname you own

kubectl apply -k overlays/prod

# Wait for the deployment to become ready
kubectl get deploy -n airtasker-chris-default -w

# In your DNS provider, create an record from hostname to the load balancer's IP or DNS name

# Check the app (if https://airtasker.chris-nie.com as hostname)
curl https://airtasker.chris-nie.com
curl https://airtasker.chris-nie.com/_health
```

## License

This project is licensed under the [MIT License](https://choosealicense.com/licenses/mit/).
