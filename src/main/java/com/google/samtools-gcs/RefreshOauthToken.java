package com.google.samtools;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.auth.oauth2.TokenResponseException;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.auth.oauth2.GoogleRefreshTokenRequest;
import com.google.api.client.http.HttpTransport;
import com.google.cloud.dataflow.sdk.options.GcpOptions;
import com.google.cloud.genomics.utils.CredentialFactory;

import java.io.IOException;

class RefreshOauthToken {
  public static void main(String[] args) {
    Credential c = CredentialFactory.getCredentialFromClientSecrets(
      "client_secret.json", "credential-refresher");
    System.out.println("got credential from file");
    try {
      if (!c.refreshToken()) {
        System.out.println("Failed to refresh token!");
      }
    } catch (IOException e) {
    }
    System.out.println("TOKEN IS: " + c.getAccessToken());
  }
}

