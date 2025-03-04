package io.vertx.ext.auth;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.codegen.json.annotations.JsonGen;
import io.vertx.core.json.JsonObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@DataObject
@JsonGen(publicConverter = false)
public class JWTOptions {

  private static final JsonObject EMPTY = new JsonObject(Collections.emptyMap());

  private int leeway = 0;
  private boolean ignoreExpiration;
  private String algorithm = "HS256";
  private JsonObject header = EMPTY;
  private boolean noTimestamp;
  private int expires;
  private List<String> audience;
  private String issuer;
  private String subject;
  private List<String> permissions;
  private String nonceAlgorithm;

  public JWTOptions() {
  }

  public JWTOptions(JWTOptions other) {
    this.leeway = other.leeway;
    this.ignoreExpiration = other.ignoreExpiration;
    this.algorithm = other.algorithm;
    this.header = other.header;
    this.noTimestamp = other.noTimestamp;
    this.expires = other.expires;
    this.audience = other.audience;
    this.issuer = other.issuer;
    this.subject = other.subject;
    this.permissions = other.permissions;
    this.nonceAlgorithm = other.nonceAlgorithm;
  }

  public JWTOptions(JsonObject json) {
    JWTOptionsConverter.fromJson(json, this);
  }

  public JsonObject toJson() {
    final JsonObject json = new JsonObject();
    JWTOptionsConverter.toJson(this, json);
    return json;
  }

  public int getLeeway() {
    return leeway;
  }

  public JWTOptions setLeeway(int leeway) {
    this.leeway = leeway;
    return this;
  }

  public boolean isIgnoreExpiration() {
    return ignoreExpiration;
  }

  public JWTOptions setIgnoreExpiration(boolean ignoreExpiration) {
    this.ignoreExpiration = ignoreExpiration;
    return this;
  }

  public String getAlgorithm() {
    return algorithm;
  }

  public JWTOptions setAlgorithm(String algorithm) {
    this.algorithm = algorithm;
    return this;
  }

  public JsonObject getHeader() {
    return header;
  }

  public JWTOptions setHeader(JsonObject header) {
    this.header = header;
    return this;
  }

  public boolean isNoTimestamp() {
    return noTimestamp;
  }

  public JWTOptions setNoTimestamp(boolean noTimestamp) {
    this.noTimestamp = noTimestamp;
    return this;
  }

  public int getExpiresInSeconds() {
    return expires;
  }

  public JWTOptions setExpiresInSeconds(int expires) {
    this.expires = expires;
    return this;
  }

  public JWTOptions setExpiresInMinutes(int expiresInMinutes) {
    this.expires = expiresInMinutes * 60;
    return this;
  }

  public List<String> getAudience() {
    return audience;
  }

  public JWTOptions setAudience(List<String> audience) {
    this.audience = audience;
    return this;
  }

  public JWTOptions addAudience(String audience) {
    if (this.audience == null) {
      this.audience = new ArrayList<>();
    }
    this.audience.add(audience);
    return this;
  }

  public String getIssuer() {
    return issuer;
  }

  public JWTOptions setIssuer(String issuer) {
    this.issuer = issuer;
    return this;
  }

  public String getSubject() {
    return subject;
  }

  public JWTOptions setSubject(String subject) {
    this.subject = subject;
    return this;
  }

  /**
   * @deprecated See {@code JWTAuthorization} for a correct way to handle permissions.
   * The permissions of this token.
   *
   * @param permissions the permissions for this token that will be used for AuthZ
   * @return fluent API
   */
  @Deprecated
  public JWTOptions setPermissions(List<String> permissions) {
    this.permissions = permissions;
    return this;
  }

  /**
   * @deprecated See {@code JWTAuthorization} for a correct way to handle permissions.
   * Add a permission to this token.
   *
   * @param permission permission for this token that will be used for AuthZ
   * @return fluent API
   */
  @Deprecated
  public JWTOptions addPermission(String permission) {
    if (this.permissions == null) {
      this.permissions = new ArrayList<>();
    }
    this.permissions.add(permission);
    return this;
  }

  @Deprecated
  public List<String> getPermissions() {
    return permissions;
  }

  public String getNonceAlgorithm() {
    return nonceAlgorithm;
  }

  public JWTOptions setNonceAlgorithm(String nonceAlgorithm) {
    this.nonceAlgorithm = nonceAlgorithm;
    return this;
  }
}
