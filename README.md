# 💲CryptoAdvisorDemo 🪙

![GitHub](https://img.shields.io/github/license/johnnysn/cryptoadvisordemo)

Spring Boot demo application to provide insight into the cryptocurrency market. 
This is a proof-of-concept app using the OpenAI [Function Calling](https://platform.openai.com/docs/guides/function-calling) feature
through the [Spring AI](https://spring.io/projects/spring-ai) framework.

## Prerequisites

Before you begin, ensure you have met the following requirement:

- Java Development Kit (JDK) 21 or higher installed on your system.

## Running the application

1. Clone this repository to your local machine:

   ```shell
   git clone https://github.com/johnnysn/cryptoadvisordemo.git
   ```

2. Navigate to the project directory:

   ```shell
   cd cryptoadvisordemo
   ```

3. Configure the application:

   To connect your application with OpenAI, you need to set the `OPENAI_API_KEY` environment variable.

    ```shell
    export OPENAI_API_KEY=your_api_key_here
    ```

4. Build and run the application:

   ```shell
   ./gradlew bootRun
   ```

5. The application should start, and you can access it at `http://localhost:8080`.

## Endpoints

1. **Crypto overview**:
    - Endpoint: GET `/advice/overview/{cryptoSymbol}`
    - Description: Get a short assessment about the specified crypto market quotation. Possible values for *cryptoSymbol* are BTC, ETH or SOL.
    - Output: The response from the chat model as a string

2. **Custom question** (Requires API Key):
    - Endpoint: POST `/advice/question`
    - Request body: A JSON containing the user's question. Example:
      ```json
      {
        "text": "Tell how Ethereum is trending today."
      }
      ```
    - Description: Make a custom question to the chat model about the crypto market. The model will have access to real-time info about BTC, ETH or SOL.
    - Output: The response from the chat model as a string

## License

This project is licensed under the [MIT License](LICENSE).