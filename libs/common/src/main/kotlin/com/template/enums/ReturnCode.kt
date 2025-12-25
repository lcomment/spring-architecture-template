package com.template.enums

enum class ReturnCode(
    val code: String,
    val message: String
) {

    SUCCESS("1000", "요청에 성공하셨습니다."),

    // 토큰 관련 (1100 ~ 1150)
    NOT_EXIST_BEARER_SUFFIX("1100", "Bearer 접두사가 포함되지 않았습니다."),
    WRONG_JWT_TOKEN("1101", "잘못된 jwt 토큰입니다."),
    EXPIRED_JWT_TOKEN("1102", "만료된 jwt 토큰입니다."),
    EMPTY_AUTH_JWT("1103", "인증 정보가 비어있는 jwt 토큰입니다."),
    INVALID_KEY("1104", "잘못된 key 입니다"),

    // 클라이언트 에러
    WRONG_PARAMETER("9000", "잘못된 파라미터 입니다."),
    METHOD_NOT_ALLOWED("9001", "허용되지 않은 메소드 입니다."),

    // 서버 에러 (9997 ~ 9999)
    INTERNAL_SERVER_ERROR("9999", "내부 서버 에러 입니다."),
}
