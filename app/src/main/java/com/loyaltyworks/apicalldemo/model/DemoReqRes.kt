package com.loyaltyworks.apicalldemo.model
import com.squareup.moshi.JsonClass

import com.squareup.moshi.Json

/*** Demo Request ***/
@JsonClass(generateAdapter = true)
data class DemoRequest(
    @Json(name = "ActionType")
    val actionType: String? = null,
    @Json(name = "ActorId")
    val actorId: String? = null,
    @Json(name = "PageSize")
    val pageSize: String? = null,
    @Json(name = "StartIndex")
    val startIndex: String? = null
)

/*** Demo Response ***/
@JsonClass(generateAdapter = true)
data class DemoResponse(
    @Json(name = "lstEventManagementDetails")
    val lstEventManagementDetails: Any? = null,
    @Json(name = "lstEventManagementDetailsAPI")
    val lstEventManagementDetailsAPI: List<LstEventManagementDetailsAPI>? = null,
    @Json(name = "ReturnMessage")
    val returnMessage: Any? = null,
    @Json(name = "ReturnValue")
    val returnValue: Int? = null,
    @Json(name = "TotalRecords")
    val totalRecords: Int? = null
)

@JsonClass(generateAdapter = true)
data class LstEventManagementDetailsAPI(
    @Json(name = "BeneficiaryDetails")
    val beneficiaryDetails: String? = null,
    @Json(name = "EventDate")
    val eventDate: String? = null,
    @Json(name = "EventMeetInfoId")
    val eventMeetInfoId: Int? = null,
    @Json(name = "EventMeetType")
    val eventMeetType: Any? = null,
    @Json(name = "EventName")
    val eventName: Any? = null,
    @Json(name = "EventTypeName")
    val eventTypeName: String? = null,
    @Json(name = "Remarks")
    val remarks: String? = null,
    @Json(name = "RowCount")
    val rowCount: Int? = null,
    @Json(name = "TopicDiscussed")
    val topicDiscussed: String? = null,
    @Json(name = "TotalRows")
    val totalRows: Int? = null
)

