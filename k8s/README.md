# Kubernetes Configuration for Deploying airtasker-demo App

## Usage

### Deploy with Default Settings

```bash
# Create the namespace first
kubectl create ns airtasker-chris-default

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
# Check the app
curl https://airtasker.chris-nie.com
curl https://airtasker.chris-nie.com/_health
```

## License

This project is licensed under the [MIT License](https://choosealicense.com/licenses/mit/).
