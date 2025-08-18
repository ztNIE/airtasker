# airtasker-demo

`airtasker-demo` is a sample application created for interview demonstration purposes.

## Build

```bash
# Build for the same architecture as your machine
docker build . -t ztnie/airtasker-demo

# Multi-architecture build
docker buildx create --use
docker buildx build --platform linux/amd64,linux/arm64 -t ztnie/airtasker-demo:latest --push .
# (Replace with your own Docker registry if needed)
```

## Run Locally

```bash
docker compose up --build -d

# Check if the service is running
curl http://localhost:8080/_health
```

## License

This project is licensed under the [MIT License](https://choosealicense.com/licenses/mit/).