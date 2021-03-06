/*
 * Zuora API Reference
 *  # Introduction  Welcome to the reference for the Zuora REST API!  <a href=\"http://en.wikipedia.org/wiki/REST_API\" target=\"_blank\">REST</a> is a web-service protocol that lends itself to rapid development by using everyday HTTP and JSON technology.  The Zuora REST API provides a broad set of operations and resources that:  * Enable Web Storefront integration between your websites. * Support self-service subscriber sign-ups and account management. * Process revenue schedules through custom revenue rule models.  ## Endpoints  The Zuora REST services are provided via the following endpoints.  | Service                 | Base URL for REST Endpoints                                                                                                                                         | |-------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------| | Production REST service | https://rest.zuora.com/v1                                                                                                                                           | | Sandbox REST service    | https://rest.apisandbox.zuora.com/v1                                                                                                                                |  The production service provides access to your live user data. The sandbox environment is a good place to test your code without affecting real-world data. To use it, you must be provisioned with a sandbox tenant - your Zuora representative can help with this if needed.  ## Accessing the API  If you have a Zuora tenant, you already have access the the API.  If you don't have a Zuora tenant, go to <a href=\"https://www.zuora.com/resource/zuora-test-drive\" target=\"_blank\">https://www.zuora.com/resource/zuora-test-drive</a> and sign up for a trial tenant. The tenant comes with seed data, such as a sample product catalog.   We recommend that you <a href=\"https://knowledgecenter.zuora.com/CF_Users_and_Administrators/A_Administrator_Settings/Manage_Users/Create_an_API_User\" target=\"_blank\">create an API user</a> specifically for making API calls. Don't log in to the Zuora UI with this account. Logging in to the UI enables a security feature that periodically expires the account's password, which may eventually cause authentication failures with the API. Note that a user role does not have write access to Zuora REST services unless it has the API Write Access permission as described in those instructions.   # Authentication  There are three ways to authenticate:  * Use an authorization cookie. The cookie authorizes the user to make calls to the REST API for the duration specified in  **Administration > Security Policies > Session timeout**. The cookie expiration time is reset with this duration after every call to the REST API. To obtain a cookie, call the REST  `connections` resource with the following API user information:     *   ID     *   password     *   entity Id or entity name (Only for [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity \"Multi-entity\"). See \"Entity Id and Entity Name\" below for more information.)  *   Include the following parameters in the request header, which re-authenticates the user with each request:     *   `apiAccessKeyId`     *   `apiSecretAccessKey`     *   `entityId` or `entityName` (Only for [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity \"Multi-entity\"). See \"Entity Id and Entity Name\" below for more information.) *   For CORS-enabled APIs only: Include a 'single-use' token in the request header, which re-authenticates the user with each request. See below for more details.   ## Entity Id and Entity Name  The `entityId` and `entityName`  parameters are only used for  [Zuora Multi-entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity).  The  `entityId` parameter specifies the Id of the entity that you want to access. The `entityName` parameter specifies the [name of the entity](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity/B_Introduction_to_Entity_and_Entity_Hierarchy#Name_and_Display_Name \"Introduction to Entity and Entity Hierarchy\") that you want to access. Note that you must have permission to access the entity. You can get the entity Id and entity name through the REST GET Entities call.  You can specify either the  `entityId` or `entityName` parameter in the authentication to access and view an entity.  *   If both `entityId` and `entityName` are specified in the authentication, an error occurs.  *   If neither  `entityId` nor  `entityName` is specified in the authentication, you will log in to the entity in which your user account is created.   See [API User Authentication](https://knowledgecenter.zuora.com/BB_Introducing_Z_Business/Multi-entity/A_Overview_of_Multi-entity#API_User_Authentication \"Zuora Multi-entity\") for more information.  ## Token Authentication for CORS-Enabled APIs  The CORS mechanism enables REST API calls to Zuora to be made directly from your customer's browser, with all credit card and security information transmitted directly to Zuora. This minimizes your PCI compliance burden, allows you to implement advanced validation on your payment forms, and makes your payment forms look just like any other part of your website.  For security reasons, instead of using cookies, an API request via CORS uses **tokens** for authentication.  The token method of authentication is only designed for use with requests that must originate from your customer's browser; **it should not be considered a replacement to the existing cookie authentication** mechanism.  See [Zuora CORS REST ](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics/G_CORS_REST \"Zuora CORS REST\")for details on how CORS works and how you can begin to implement customer calls to the Zuora REST APIs. See  [HMAC Signatures](/BC_Developers/REST_API/B_REST_API_reference/HMAC_Signatures \"HMAC Signatures\") for details on the HMAC method that returns the authentication token.    # Requests and Responses   ## Request IDs  As a general rule, when asked to supply a \"key\" for an account or subscription (accountKey, account-key, subscriptionKey, subscription-key), you can provide either the actual ID or the number of the entity.  ## HTTP Request Body  Most of the parameters and data accompanying your requests will be contained in the body of the HTTP request.  The Zuora REST API accepts JSON in the HTTP request body.  No other data format (e.g., XML) is supported.   ## Testing a Request  Use a third party client, such as Postman or Advanced REST Client, to test the Zuora REST API.  You can test the Zuora REST API from the Zuora sandbox or  production service. If connecting to the production service, bear in mind that you are working with your live production data, not sample data or test data.  ## Testing with Credit Cards  Sooner or later it will probably be necessary to test some transactions that involve credit cards. For suggestions on how to handle this, see [Going Live With Your Payment Gateway](https://knowledgecenter.zuora.com/CB_Billing/M_Payment_Gateways/C_Managing_Payment_Gateways/B_Going_Live_Payment_Gateways#Testing_with_Credit_Cards \"C_Zuora_User_Guides/A_Billing_and_Payments/M_Payment_Gateways/C_Managing_Payment_Gateways/B_Going_Live_Payment_Gateways#Testing_with_Credit_Cards\").       ## Error Handling  Responses and error codes are detailed in [Responses and errors](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics/3_Responses_and_errors \"Responses and errors\").    # Pagination  When retrieving information (using GET methods), the optional `pageSize` query parameter sets the maximum number of rows to return in a response. The maximum is `40`; larger values are treated as `40`. If this value is empty or invalid, `pageSize` typically defaults to `10`.  The default value for the maximum number of rows retrieved can be overridden at the method level.  If more rows are available, the response will include a `nextPage` element, which contains a URL for requesting the next page.  If this value is not provided, no more rows are available. No \"previous page\" element is explicitly provided; to support backward paging, use the previous call.  ## Array Size  For data items that are not paginated, the REST API supports arrays of up to 300 rows.  Thus, for instance, repeated pagination can retrieve thousands of customer accounts, but within any account an array of no more than 300 rate plans is returned.   # API Versions  The Zuora REST API is in version control. Versioning ensures that Zuora REST API changes are backward compatible. Zuora uses a major and minor version nomenclature to manage changes. By specifying a version in a REST request, you can get expected responses regardless of future changes to the API.   ## Major Version  The major version number of the REST API appears in the REST URL. Currently, Zuora only supports the **v1** major version. For example,  `POST https://rest.zuora.com/v1/subscriptions` .   ## Minor Version  Zuora uses minor versions for the REST API to control small changes. For example, a field in a REST method is deprecated and a new field is used to replace it.   Some fields in the REST methods are supported as of minor versions. If a field is not noted with a minor version, this field is available for all minor versions. If a field is noted with a minor version, this field is in version control. You must specify the supported minor version in the request header to process without an error.   If a field is in version control, it is either with a minimum minor version or a maximum minor version, or both of them. You can only use this field with the minor version between the minimum and the maximum minor versions. For example, the  `invoiceCollect` field in the POST Subscription method is in version control and its maximum minor version is 189.0. You can only use this field with the minor version 189.0 or earlier.  The supported minor versions are not serial, see [Zuora REST API Minor Version History](https://knowledgecenter.zuora.com/DC_Developers/REST_API/A_REST_basics/Zuora_REST_API_Minor_Version_History \"Zuora REST API Minor Version History\") for the fields and their supported minor versions. In our REST API documentation, if a field or feature requires a minor version number, we note that in the field description.  You only need to specify the version number when you use the fields require a minor version. To specify the minor version, set the `zuora-version` parameter to the minor version number in the request header for the request call. For example, the `collect` field is in 196.0 minor version. If you want to use this field for the POST Subscription method, set the  `zuora-version` parameter to `196.0` in the request header. The `zuora-version` parameter is case sensitive.   For all the REST API fields, by default, if the minor version is not specified in the request header, Zuora will use the minimum minor version of the REST API to avoid breaking your integration.     # Zuora Object Model The following diagram presents a high-level view of the key Zuora objects. Click the image to open it in a new tab to resize it.  <a href=\"https://www.zuora.com/wp-content/uploads/2016/10/ZuoraERD-compressor-1.jpeg\" target=\"_blank\"><img src=\"https://www.zuora.com/wp-content/uploads/2016/10/ZuoraERD-compressor-1.jpeg\" alt=\"Zuora Object Model Diagram\"></a> 
 *
 * OpenAPI spec version: 0.0.1
 * Contact: docs@zuora.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.client.model.GETAccountingPeriodFileIdsType;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;


/**
 * GETAccountingPeriodType
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-10-31T11:45:12.183-07:00")
public class GETAccountingPeriodType   {
  @SerializedName("createdBy")
  private String createdBy = null;

  @SerializedName("createdOn")
  private DateTime createdOn = null;

  @SerializedName("customField__c")
  private String customFieldC = null;

  @SerializedName("endDate")
  private LocalDate endDate = null;

  @SerializedName("fileIds")
  private List<GETAccountingPeriodFileIdsType> fileIds = new ArrayList<GETAccountingPeriodFileIdsType>();

  @SerializedName("fiscalYear")
  private String fiscalYear = null;

  @SerializedName("fiscal_quarter")
  private Long fiscalQuarter = null;

  @SerializedName("id")
  private String id = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("notes")
  private String notes = null;

  @SerializedName("runTrialBalanceEnd")
  private DateTime runTrialBalanceEnd = null;

  @SerializedName("runTrialBalanceErrorMessage")
  private String runTrialBalanceErrorMessage = null;

  @SerializedName("runTrialBalanceStart")
  private DateTime runTrialBalanceStart = null;

  @SerializedName("runTrialBalanceStatus")
  private String runTrialBalanceStatus = null;

  @SerializedName("startDate")
  private LocalDate startDate = null;

  @SerializedName("status")
  private String status = null;

  @SerializedName("success")
  private Boolean success = null;

  @SerializedName("updatedBy")
  private String updatedBy = null;

  @SerializedName("updatedOn")
  private DateTime updatedOn = null;

  public GETAccountingPeriodType createdBy(String createdBy) {
    this.createdBy = createdBy;
    return this;
  }

   /**
   * ID of the user who created the accounting period. 
   * @return createdBy
  **/
  @ApiModelProperty(example = "null", value = "ID of the user who created the accounting period. ")
  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public GETAccountingPeriodType createdOn(DateTime createdOn) {
    this.createdOn = createdOn;
    return this;
  }

   /**
   * Date and time when the accounting period was created. 
   * @return createdOn
  **/
  @ApiModelProperty(example = "null", value = "Date and time when the accounting period was created. ")
  public DateTime getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(DateTime createdOn) {
    this.createdOn = createdOn;
  }

  public GETAccountingPeriodType customFieldC(String customFieldC) {
    this.customFieldC = customFieldC;
    return this;
  }

   /**
   * Any custom fields defined for this object. 
   * @return customFieldC
  **/
  @ApiModelProperty(example = "null", value = "Any custom fields defined for this object. ")
  public String getCustomFieldC() {
    return customFieldC;
  }

  public void setCustomFieldC(String customFieldC) {
    this.customFieldC = customFieldC;
  }

  public GETAccountingPeriodType endDate(LocalDate endDate) {
    this.endDate = endDate;
    return this;
  }

   /**
   * The end date of the accounting period. 
   * @return endDate
  **/
  @ApiModelProperty(example = "null", value = "The end date of the accounting period. ")
  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public GETAccountingPeriodType fileIds(List<GETAccountingPeriodFileIdsType> fileIds) {
    this.fileIds = fileIds;
    return this;
  }

  public GETAccountingPeriodType addFileIdsItem(GETAccountingPeriodFileIdsType fileIdsItem) {
    this.fileIds.add(fileIdsItem);
    return this;
  }

   /**
   * File IDs of the reports available for the accounting period. You can retrieve the reports by specifying the file ID in a [Get Files](https://knowledgecenter.zuora.com/DC_Developers/REST_API/B_REST_API_reference/Get_Files) REST API call. 
   * @return fileIds
  **/
  @ApiModelProperty(example = "null", value = "File IDs of the reports available for the accounting period. You can retrieve the reports by specifying the file ID in a [Get Files](https://knowledgecenter.zuora.com/DC_Developers/REST_API/B_REST_API_reference/Get_Files) REST API call. ")
  public List<GETAccountingPeriodFileIdsType> getFileIds() {
    return fileIds;
  }

  public void setFileIds(List<GETAccountingPeriodFileIdsType> fileIds) {
    this.fileIds = fileIds;
  }

  public GETAccountingPeriodType fiscalYear(String fiscalYear) {
    this.fiscalYear = fiscalYear;
    return this;
  }

   /**
   * Fiscal year of the accounting period. 
   * @return fiscalYear
  **/
  @ApiModelProperty(example = "null", value = "Fiscal year of the accounting period. ")
  public String getFiscalYear() {
    return fiscalYear;
  }

  public void setFiscalYear(String fiscalYear) {
    this.fiscalYear = fiscalYear;
  }

  public GETAccountingPeriodType fiscalQuarter(Long fiscalQuarter) {
    this.fiscalQuarter = fiscalQuarter;
    return this;
  }

   /**
   * dummy
   * @return fiscalQuarter
  **/
  @ApiModelProperty(example = "null", value = "dummy")
  public Long getFiscalQuarter() {
    return fiscalQuarter;
  }

  public void setFiscalQuarter(Long fiscalQuarter) {
    this.fiscalQuarter = fiscalQuarter;
  }

  public GETAccountingPeriodType id(String id) {
    this.id = id;
    return this;
  }

   /**
   * ID of the accounting period. 
   * @return id
  **/
  @ApiModelProperty(example = "null", value = "ID of the accounting period. ")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public GETAccountingPeriodType name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Name of the accounting period. 
   * @return name
  **/
  @ApiModelProperty(example = "null", value = "Name of the accounting period. ")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GETAccountingPeriodType notes(String notes) {
    this.notes = notes;
    return this;
  }

   /**
   * Any optional notes about the accounting period. 
   * @return notes
  **/
  @ApiModelProperty(example = "null", value = "Any optional notes about the accounting period. ")
  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public GETAccountingPeriodType runTrialBalanceEnd(DateTime runTrialBalanceEnd) {
    this.runTrialBalanceEnd = runTrialBalanceEnd;
    return this;
  }

   /**
   * Date and time that the trial balance was completed. If the trial balance status is `Pending`, `Processing`, or `Error`, this field is `null`. 
   * @return runTrialBalanceEnd
  **/
  @ApiModelProperty(example = "null", value = "Date and time that the trial balance was completed. If the trial balance status is `Pending`, `Processing`, or `Error`, this field is `null`. ")
  public DateTime getRunTrialBalanceEnd() {
    return runTrialBalanceEnd;
  }

  public void setRunTrialBalanceEnd(DateTime runTrialBalanceEnd) {
    this.runTrialBalanceEnd = runTrialBalanceEnd;
  }

  public GETAccountingPeriodType runTrialBalanceErrorMessage(String runTrialBalanceErrorMessage) {
    this.runTrialBalanceErrorMessage = runTrialBalanceErrorMessage;
    return this;
  }

   /**
   * If trial balance status is Error, an error message is returned in this field. 
   * @return runTrialBalanceErrorMessage
  **/
  @ApiModelProperty(example = "null", value = "If trial balance status is Error, an error message is returned in this field. ")
  public String getRunTrialBalanceErrorMessage() {
    return runTrialBalanceErrorMessage;
  }

  public void setRunTrialBalanceErrorMessage(String runTrialBalanceErrorMessage) {
    this.runTrialBalanceErrorMessage = runTrialBalanceErrorMessage;
  }

  public GETAccountingPeriodType runTrialBalanceStart(DateTime runTrialBalanceStart) {
    this.runTrialBalanceStart = runTrialBalanceStart;
    return this;
  }

   /**
   * Date and time that the trial balance was run. If the trial balance status is Pending, this field is null. 
   * @return runTrialBalanceStart
  **/
  @ApiModelProperty(example = "null", value = "Date and time that the trial balance was run. If the trial balance status is Pending, this field is null. ")
  public DateTime getRunTrialBalanceStart() {
    return runTrialBalanceStart;
  }

  public void setRunTrialBalanceStart(DateTime runTrialBalanceStart) {
    this.runTrialBalanceStart = runTrialBalanceStart;
  }

  public GETAccountingPeriodType runTrialBalanceStatus(String runTrialBalanceStatus) {
    this.runTrialBalanceStatus = runTrialBalanceStatus;
    return this;
  }

   /**
   * Status of the trial balance for the accounting period. Possible values:  * `Pending` * `Processing` * `Completed` * `Error` 
   * @return runTrialBalanceStatus
  **/
  @ApiModelProperty(example = "null", value = "Status of the trial balance for the accounting period. Possible values:  * `Pending` * `Processing` * `Completed` * `Error` ")
  public String getRunTrialBalanceStatus() {
    return runTrialBalanceStatus;
  }

  public void setRunTrialBalanceStatus(String runTrialBalanceStatus) {
    this.runTrialBalanceStatus = runTrialBalanceStatus;
  }

  public GETAccountingPeriodType startDate(LocalDate startDate) {
    this.startDate = startDate;
    return this;
  }

   /**
   * The start date of the accounting period. 
   * @return startDate
  **/
  @ApiModelProperty(example = "null", value = "The start date of the accounting period. ")
  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public GETAccountingPeriodType status(String status) {
    this.status = status;
    return this;
  }

   /**
   * Status of the accounting period. Possible values: * `Open` * `PendingClose` * `Closed` 
   * @return status
  **/
  @ApiModelProperty(example = "null", value = "Status of the accounting period. Possible values: * `Open` * `PendingClose` * `Closed` ")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public GETAccountingPeriodType success(Boolean success) {
    this.success = success;
    return this;
  }

   /**
   * Returns `true` if the request was processed successfully. 
   * @return success
  **/
  @ApiModelProperty(example = "null", value = "Returns `true` if the request was processed successfully. ")
  public Boolean getSuccess() {
    return success;
  }

  public void setSuccess(Boolean success) {
    this.success = success;
  }

  public GETAccountingPeriodType updatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
    return this;
  }

   /**
   * ID of the user who last updated the accounting period. 
   * @return updatedBy
  **/
  @ApiModelProperty(example = "null", value = "ID of the user who last updated the accounting period. ")
  public String getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
  }

  public GETAccountingPeriodType updatedOn(DateTime updatedOn) {
    this.updatedOn = updatedOn;
    return this;
  }

   /**
   * Date and time when the accounting period was last updated. 
   * @return updatedOn
  **/
  @ApiModelProperty(example = "null", value = "Date and time when the accounting period was last updated. ")
  public DateTime getUpdatedOn() {
    return updatedOn;
  }

  public void setUpdatedOn(DateTime updatedOn) {
    this.updatedOn = updatedOn;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GETAccountingPeriodType gETAccountingPeriodType = (GETAccountingPeriodType) o;
    return Objects.equals(this.createdBy, gETAccountingPeriodType.createdBy) &&
        Objects.equals(this.createdOn, gETAccountingPeriodType.createdOn) &&
        Objects.equals(this.customFieldC, gETAccountingPeriodType.customFieldC) &&
        Objects.equals(this.endDate, gETAccountingPeriodType.endDate) &&
        Objects.equals(this.fileIds, gETAccountingPeriodType.fileIds) &&
        Objects.equals(this.fiscalYear, gETAccountingPeriodType.fiscalYear) &&
        Objects.equals(this.fiscalQuarter, gETAccountingPeriodType.fiscalQuarter) &&
        Objects.equals(this.id, gETAccountingPeriodType.id) &&
        Objects.equals(this.name, gETAccountingPeriodType.name) &&
        Objects.equals(this.notes, gETAccountingPeriodType.notes) &&
        Objects.equals(this.runTrialBalanceEnd, gETAccountingPeriodType.runTrialBalanceEnd) &&
        Objects.equals(this.runTrialBalanceErrorMessage, gETAccountingPeriodType.runTrialBalanceErrorMessage) &&
        Objects.equals(this.runTrialBalanceStart, gETAccountingPeriodType.runTrialBalanceStart) &&
        Objects.equals(this.runTrialBalanceStatus, gETAccountingPeriodType.runTrialBalanceStatus) &&
        Objects.equals(this.startDate, gETAccountingPeriodType.startDate) &&
        Objects.equals(this.status, gETAccountingPeriodType.status) &&
        Objects.equals(this.success, gETAccountingPeriodType.success) &&
        Objects.equals(this.updatedBy, gETAccountingPeriodType.updatedBy) &&
        Objects.equals(this.updatedOn, gETAccountingPeriodType.updatedOn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createdBy, createdOn, customFieldC, endDate, fileIds, fiscalYear, fiscalQuarter, id, name, notes, runTrialBalanceEnd, runTrialBalanceErrorMessage, runTrialBalanceStart, runTrialBalanceStatus, startDate, status, success, updatedBy, updatedOn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GETAccountingPeriodType {\n");
    
    sb.append("    createdBy: ").append(toIndentedString(createdBy)).append("\n");
    sb.append("    createdOn: ").append(toIndentedString(createdOn)).append("\n");
    sb.append("    customFieldC: ").append(toIndentedString(customFieldC)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    fileIds: ").append(toIndentedString(fileIds)).append("\n");
    sb.append("    fiscalYear: ").append(toIndentedString(fiscalYear)).append("\n");
    sb.append("    fiscalQuarter: ").append(toIndentedString(fiscalQuarter)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    runTrialBalanceEnd: ").append(toIndentedString(runTrialBalanceEnd)).append("\n");
    sb.append("    runTrialBalanceErrorMessage: ").append(toIndentedString(runTrialBalanceErrorMessage)).append("\n");
    sb.append("    runTrialBalanceStart: ").append(toIndentedString(runTrialBalanceStart)).append("\n");
    sb.append("    runTrialBalanceStatus: ").append(toIndentedString(runTrialBalanceStatus)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
    sb.append("    updatedBy: ").append(toIndentedString(updatedBy)).append("\n");
    sb.append("    updatedOn: ").append(toIndentedString(updatedOn)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

