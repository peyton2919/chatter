package cn.peyton.core.enums;

/**
 * <h3>网络 状态码</h3>
 * <pre>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @date 2022/3/19 13:14
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @version 1.0.0
 * </pre>
 */
public enum HttpStatusCode {
    /** 成功 返回码: 200 {请求已成功，请求所希望的响应头或数据体将随此响应返回。} */
    SUCCESS(200,"请求已成功，请求所希望的响应头或数据体将随此响应返回。"),
    /** 成功 返回码: 201 {请求已经被实现，而且有一个新的资源已经依据请求的需要而建立，且其 URI 已经随Location 头信息返回。} */
    SUCCESS_201(201,"请求已经被实现，而且有一个新的资源已经依据请求的需要而建立，且其 URI 已经随Location 头信息返回。"),
    /** 成功 返回码: 202 {服务器已接受请求，但尚未处理。正如它可能被拒绝一样，最终该请求可能会也可能不会被执行。} */
    SUCCESS_202(202,"服务器已接受请求，但尚未处理。正如它可能被拒绝一样，最终该请求可能会也可能不会被执行。"),
    /** 成功 返回码: 203 {服务器已成功处理了请求，但返回的信息可能来自另一来源。} */
    SUCCESS_203(203,"服务器已成功处理了请求，但返回的信息可能来自另一来源。"),
    /** 成功 返回码: 204 {服务器成功处理了请求，但不需要返回任何实体内容，并且希望返回更新了的元信息。} */
    SUCCESS_204(204,"服务器成功处理了请求，但不需要返回任何实体内容，并且希望返回更新了的元信息。"),
    /** 成功 返回码: 205 {服务器成功处理了请求，但没有返回任何内容。} */
    SUCCESS_205(205,"服务器成功处理了请求，但没有返回任何内容。"),
    /** 成功 返回码: 206 { 服务器成功处理了部分 GET 请求。} */
    SUCCESS_206(206," 服务器成功处理了部分 GET 请求。"),
    /** 成功 返回码：20101 {注册成功。} */
    SUCCESS_REGISTER(20101,"注册成功。"),
    /** 成功 返回码：20102 {成功退出。} */
    SUCCESS_OUT_LOGIN(20102,"成功退出。"),
    /** 成功 返回码：20103 {绑定成功。} */
    SUCCESS_BINDING(20103,"绑定成功。"),
    /** 成功 返回码：20104 {登录成功。} */
    SUCCESS_LOGIN(20104,"登录成功。"),
    /** 成功 返回码：20105 {头像更新成功。} */
    SUCCESS_AVATAR_UPDATE(20105,"头像更新成功。"),
    /** 成功 返回码：20106 {用户更新成功。} */
    SUCCESS_USER_UPDATE(20106,"用户更新成功。"),
    /** 成功 返回码：20107 {密码更新成功。} */
    SUCCESS_PASSWORD_UPDATE(20107,"密码更新成功。"),
    /** 成功 返回码：20108 {数据操作成功。} */
    SUCCESS_OPERATE_UPDATE(20108,"数据操作成功。"),

    /** 错误  返回码：40998 {} */
    FAIL(40998,"程序出错了，请联系管理员(^~^)(^~^)(^~^)。"),
    /** 错误  返回码： {请求已经被服务器接收，且仍未被拒绝,应当继续发送请求的剩余部分。} */
    FAIL_100(100,"请求已经被服务器接收，且仍未被拒绝,应当继续发送请求的剩余部分。"),
    /** 错误  返回码：101 {服务器已经理解了客户端的请求，并将通过Upgrade 消息头通知客户端采用不同的协议来完成这个请求。} */
    FAIL_101(101,"服务器已经理解了客户端的请求，并将通过Upgrade 消息头通知客户端采用不同的协议来完成这个请求。"),
    /** 错误  返回码：102 {由WebDAV（RFC 2518）扩展的状态码，代表处理将被继续执行。} */
    FAIL_102(102,"由WebDAV（RFC 2518）扩展的状态码，代表处理将被继续执行。"),

    /** 错误 返回码：300 {（多种选择） 针对请求，服务器可执行多种操作。服务器可根据请求者 （user agent） 选择一项操作，或提供操作列表供请求者选择。} */
    FAIL_300(300,"（多种选择） 针对请求，服务器可执行多种操作。服务器可根据请求者 （user agent） 选择一项操作，或提供操作列表供请求者选择。"),
    /** 错误  返回码：301 {（永久移动） 请求的网页已永久移动到新位置。服务器返回此响应（对 GET 或 HEAD 请求的响应）时，会自动将请求者转到新位置。} */
    FAIL_301(301,"（永久移动） 请求的网页已永久移动到新位置。服务器返回此响应（对 GET 或 HEAD 请求的响应）时，会自动将请求者转到新位置。"),
    /** 错误  返回码：302 {（临时移动） 服务器目前从不同位置的网页响应请求，但请求者应继续使用原有位置来进行以后的请求。} */
    FAIL_302(302,"（临时移动） 服务器目前从不同位置的网页响应请求，但请求者应继续使用原有位置来进行以后的请求。"),
    /** 错误  返回码：303 {（查看其他位置） 请求者应当对不同的位置使用单独的 GET 请求来检索响应时，服务器返回此代码。} */
    FAIL_303(303,"（查看其他位置） 请求者应当对不同的位置使用单独的 GET 请求来检索响应时，服务器返回此代码。"),
    /** 错误  返回码：304 {（未修改） 自从上次请求后，请求的网页未修改过。服务器返回此响应时，不会返回网页内容。} */
    FAIL_304(304,"（未修改） 自从上次请求后，请求的网页未修改过。服务器返回此响应时，不会返回网页内容。"),
    /** 错误  返回码：305 {（使用代理） 请求者只能使用代理访问请求的网页。如果服务器返回此响应，还表示请求者应使用代理。} */
    FAIL_305(305,"（使用代理） 请求者只能使用代理访问请求的网页。如果服务器返回此响应，还表示请求者应使用代理。"),
    /** 错误  返回码：307 {（临时重定向） 服务器目前从不同位置的网页响应请求，但请求者应继续使用原有位置来进行以后的请求。} */
    FAIL_307(307,"（临时重定向） 服务器目前从不同位置的网页响应请求，但请求者应继续使用原有位置来进行以后的请求。"),

    /** 错误 返回码：40 {（错误请求） 服务器不理解请求的语法。} */
    ERROR(400,"（错误请求） 服务器不理解请求的语法。"),
    /** 错误  返回码： {（未授权） 请求要求身份验证。 对于需要登录的网页，服务器可能返回此响应。} */
    ERROR_401(401,"（未授权） 请求要求身份验证。 对于需要登录的网页，服务器可能返回此响应。"),
    /** 错误  返回码： {（禁止） 服务器拒绝请求。} */
    ERROR_403(403,"（禁止） 服务器拒绝请求。"),
    /**  错误 返回码： {（未找到） 服务器找不到请求的网页。} */
    ERROR_404(404,"（未找到） 服务器找不到请求的网页。"),
    /** 错误 返回码：405 {（方法禁用） 禁用请求中指定的方法。} */
    ERROR_405(405,"（方法禁用） 禁用请求中指定的方法。"),
    /** 错误 返回码：406 {（不接受） 无法使用请求的内容特性响应请求的网页。} */
    ERROR_406(406,"（不接受） 无法使用请求的内容特性响应请求的网页。"),
    /** 错误 返回码：407 {（需要代理授权） 此状态代码与 401（未授权）类似，但指定请求者应当授权使用代理。} */
    ERROR_407(407,"（需要代理授权） 此状态代码与 401（未授权）类似，但指定请求者应当授权使用代理。"),
    /** 错误 返回码：408 {（请求超时） 服务器等候请求时发生超时。} */
    ERROR_408(408,"（请求超时） 服务器等候请求时发生超时。"),
    /** 错误 返回码：409 {（冲突） 服务器在完成请求时发生冲突。服务器必须在响应中包含有关冲突的信息。} */
    ERROR_409(409,"（冲突） 服务器在完成请求时发生冲突。服务器必须在响应中包含有关冲突的信息。"),
    /** 错误 返回码：410 {（已删除） 如果请求的资源已永久删除，服务器就会返回此响应。} */
    ERROR_410(410,"（已删除） 如果请求的资源已永久删除，服务器就会返回此响应。"),
    /** 错误 返回码：411 {（需要有效长度） 服务器不接受不含有效内容长度标头字段的请求。} */
    ERROR_411(411,"（需要有效长度） 服务器不接受不含有效内容长度标头字段的请求。"),
    /** 错误 返回码：412 {（未满足前提条件） 服务器未满足请求者在请求中设置的其中一个前提条件。} */
    ERROR_412(412,"（未满足前提条件） 服务器未满足请求者在请求中设置的其中一个前提条件。"),
    /** 错误 返回码：413 {（请求实体过大） 服务器无法处理请求，因为请求实体过大，超出服务器的处理能力。} */
    ERROR_413(413,"（请求实体过大） 服务器无法处理请求，因为请求实体过大，超出服务器的处理能力。"),
    /** 错误 返回码：414 {（请求的 URI 过长） 请求的 URI（通常为网址）过长，服务器无法处理。} */
    ERROR_414(414,"（请求的 URI 过长） 请求的 URI（通常为网址）过长，服务器无法处理。"),
    /** 错误 返回码：415 {（不支持的媒体类型） 请求的格式不受请求页面的支持。} */
    ERROR_415(415,"（不支持的媒体类型） 请求的格式不受请求页面的支持。"),
    /** 错误 返回码：416 {（请求范围不符合要求） 如果页面无法提供请求的范围，则服务器会返回此状态代码。} */
    ERROR_416(416,"（请求范围不符合要求） 如果页面无法提供请求的范围，则服务器会返回此状态代码。"),
    /** 错误 返回码：417 {（未满足期望值） 服务器未满足"期望"请求标头字段的要求。} */
    ERROR_417(417,"（未满足期望值） 服务器未满足\"期望\"请求标头字段的要求。"),

    /**  错误 返回码：500 {（服务器内部错误） 服务器遇到错误，无法完成请求。} */
    FAIL_500(500,"（服务器内部错误） 服务器遇到错误，无法完成请求。"),
    /**  错误 返回码：501 {（尚未实施） 服务器不具备完成请求的功能。例如，服务器无法识别请求方法时可能会返回此代码。} */
    FAIL_501(501,"（尚未实施） 服务器不具备完成请求的功能。例如，服务器无法识别请求方法时可能会返回此代码。"),
    /**  错误 返回码：502 {（错误网关） 服务器作为网关或代理，从上游服务器收到无效响应。} */
    FAIL_502(502,"（错误网关） 服务器作为网关或代理，从上游服务器收到无效响应。"),
    /**  错误 返回码：503 {（服务不可用） 服务器目前无法使用（由于超载或停机维护）。通常，这只是暂时状态。} */
    FAIL_503(503,"（服务不可用） 服务器目前无法使用（由于超载或停机维护）。通常，这只是暂时状态。"),
    /**  错误 返回码：504 {（网关超时） 服务器作为网关或代理，但是没有及时从上游服务器收到请求。} */
    FAIL_504(504,"（网关超时） 服务器作为网关或代理，但是没有及时从上游服务器收到请求。"),
    /**  错误 返回码：505 {（HTTP 版本不受支持） 服务器不支持请求中所用的 HTTP 协议版本。} */
    FAIL_505(505,"（HTTP 版本不受支持） 服务器不支持请求中所用的 HTTP 协议版本。"),

    /** 自定义 错误 返回码：400100 {[校验] 验证出错了...} */
    ERR_VALID(400100,"[校验] 验证出错了..."),
    /** 自定义 错误 返回码：400101 {[校验] 用户名不能为空。} */
    ERR_NOT_NAME(400101,"[校验] 用户名不能为空。"),
    /** 自定义 错误 返回码：400102 {[校验] 该用户不存在。} */
    ERR_USER_NOT_EXIST(400102,"[校验] 该用户不存在。"),
    /** 自定义 错误 返回码：400103 {[校验] 该名称已被使用,请输入不同于当前的名称。} */
    ERR_USER_NAME_BE_USED(400103,"[校验] 该名称已被使用,请输入不同于当前的名称。"),
    /** 自定义 错误 返回码：400104 {[校验] 该用户被禁用,请联系客服。} */
    ERR_USER_DISABLED(400104, "[校验] 该用户不存在或可能被禁用,请联系客服。"),
    /** 自定义 错误 返回码：400105 {[校验] 密码不能为空。} */
    ERR_NOT_PASSWORD(400105,"[校验] 密码不能为空。"),
    /** 自定义 错误 返回码：400106 {[校验] 密码错误。} */
    ERR_PASSWORD_WRONG(400106, "[校验] 输入密码不正确。"),
    /** 自定义 错误 返回码：400107 {[校验] 旧密码不正确,请重新输入。} */
    ERR_OLD_PASSWORD(400107,"[校验] 旧密码不正确,请重新输入。"),
    /** 自定义 错误 返回码：400108 {[校验] 确认密码不正确,请重新输入。} */
    ERR_CONFIRM_PASSWORD(400108,"[校验] 确认密码不正确,请重新输入。"),
    /** 自定义 错误 返回码：400109 {[校验] 新密码与旧密码相同,不需要修改。} */
    ERR_NEW_OLD_PASSWORD(400109,"[校验] 新密码与旧密码相同,不需要修改。"),
    /** 自定义 错误 返回码：400110 {[校验] 用户名或密码不能为空。} */
    ERR_NOT_NAME_PWD(400110,"[校验] 用户名或密码不能为空。"),

    /** 自定义 错误 返回码：400111 {[校验] 用户名称或密码错误。} */
    ERR_USERNAME_PASSWORD_WRONG(400111,"[校验] 用户名称或密码错误。"),
    /** 自定义 错误 返回码：400112 {[校验] 手机不能为空。} */
    ERR_NOT_PHONE(400112,"[校验] 手机不能为空。"),
    /** 自定义 错误 返回码：400113 {[校验] 手机号码出错了。} */
    ERR_PHONE(400113,"[校验] 手机号码格式不正确。"),
    /** 自定义 错误 返回码：400114 {[校验] 该手机号码还未注册,请先注册。} */
    ERR_PHONE_UNREGISTERED(400114,"[校验] 该手机号码还未注册,请先注册。"),
    /** 自定义 错误 返回码：400115 {[校验] 发送验证码错误。} */
    ERR_VERIFICATION_CODE_ERROR(400115, "[校验] 发送验证码错误。"),
    /** 自定义 错误 返回码：400116 {[校验] 发送验证码太快了。} */
    ERR_SEND_VERIFICATION_FAST(400116, "[校验] 发送验证码太快了。"),
    /** 自定义 错误 返回码：400117 {[校验] 无效号码。} */
    ERR_INVALID_NUMBER(400117, "[校验] 无效号码。"),
    /** 自定义 错误 返回码：400118 {[校验] 触发日限制。} */
    ERR_TRIGGER_DAY_LIMIT(400118, "[校验] 触发日限制。"),
    /** 自定义 错误 返回码：400119 {[校验] 发送失败。} */
    ERR_FAILED_TO_SEND(400119, "[校验] 发送失败。"),

    /** 自定义 错误 返回码：400120 {[校验] 未开启发送短信。} */
    ERR_NOT_SMS_SEND(400120, "[校验] 未开启发送短信。"),

    /** 自定义 错误 返回码：400121 {[校验] 请重新获取验证码。} */
    ERR_REGET_VERIFICATION_CODE(400121, "[校验] 请重新获取验证码。"),
    /** 自定义 错误 返回码：400122 {[校验] 电话不能为空。} */
    ERR_NOT_TEL(400122,"[校验] 电话不能为空。"),
    /** 自定义 错误 返回码：400123 {[校验] 电话号码出错了。} */
    ERR_TEL(400123,"[校验] 输入电话号码格式不正确。"),
    /** 自定义 错误 返回码：400124 {[校验] 邮箱不能为空。} */
    ERR_NOT_EMAIL(400124,"[校验] 邮箱不能为空。"),
    /** 自定义 错误 返回码：400125 {[校验] 输入邮箱号码格式不正确。} */
    ERR_EMAIL(400125,"[校验] 输入邮箱号码格式不正确。"),
    /** 自定义 错误 返回码：400126 {[校验] 不能为空。} */
    ERR_NOT_OTHER(400126,"[校验] 不能为空。"),

    /** 自定义 错误 返回码：400128 {[校验] 参数错误。} */
    ERR_PARAM(400128,"[校验] 参数错误。"),
    /** 自定义 错误 返回码：400129 {[校验] 该数据不存在。} */
    ERR_NOT_EXIST(400129,"[校验] 该数据不存在。"),
    /** 自定义 错误 返回码：400130 {添加数据失败。} */
    ERR_ADD_FAILED(400130,"添加数据失败。"),
    /** 自定义 错误 返回码：400131 {更新数据失败。} */
    ERR_UPDATE_FAILED(400131,"更新数据失败。"),
    /** 自定义 错误 返回码：400132 {删除数据失败。} */
    ERR_DELETE_FAILED(400132,"删除数据失败。"),
    /** 自定义 错误 返回码：400133 {查询数据失败。} */
    ERR_SEARCH_FAILED(400133,"查询数据失败。"),

    /** 自定义 错误 返回码：400201 {请求的数据格式不符。} */
    ERR_BAD_REQUEST(400201,"请求的数据格式不符。"),
    /** 自定义 错误 返回码：400202 {绑定类型冲突。} */
    ERR_BINDING_TYPE_CONFLICT(400202, "绑定类型冲突。"),
    /** 自定义 错误 返回码：400203 {没找到绑定类型。} */
    ERR_BINDING_NOT_FIND_TYPE(400203, "没找到绑定类型。"),
    /** 自定义 错误 返回码：400204 {已经被绑定了。} */
    ERR_BINDING_HAS_BEEN_BOUND(400204, "已经被绑定了。"),

    /** 自定义 错误 返回码：400301 {不能取消操作自己。} */
    ERR_NOT_CANCEL_OPERATE_SELF(400301,"不能取消操作自己。"),
    /** 自定义 错误 返回码：400302 {没关注过。} */
    ERR_NOT_FOLLOW(400302,"没关注过。"),
    /** 自定义 错误 返回码：400303 {不能操作自己。} */
    ERR_NOT_OPERATE_SELF(400303,"不能操作自己。"),
    /** 自定义 错误 返回码：400304 {已经关注过。} */
    ERR_FOLLOW(400304,"已经关注过。"),
    /** 自定义 错误 返回码：400305 {找不到父评论。} */
    ERR_NOT_PARENT_COMMENT(400305,"找不到父评论。"),
    /** 自定义 错误 返回码：400306 {评论逻辑出错了。} */
    ERR_COMMENT_LOGIC(400306,"评论逻辑出错了。"),
    /** 自定义 错误 返回码：400307 {暂无更新版本。} */
    ERR_NOT_UPDATE_APP(400307,"暂无更新版本。"),
    /** 自定义 错误 返回码：400308 {该用户已经被你拉黑过。} */
    ERR_HAS_BEEN_BLOCKED(400308,"该用户已经被你拉黑过。"),
    /** 自定义 错误 返回码：400309 {该用户没被你拉黑过。} */
    ERR_NOT_BLOCKED(400309,"该用户没被你拉黑过。"),
    /** 自定义 错误 返回码：400310 {注册失败。} */
    ERR_REGISTER(400310,"注册失败。"),
    /** 自定义 错误 返回码：400311 {绑定失败。} */
    ERR_BINDING(400311,"绑定失败。"),
    /** 自定义 错误 返回码：400312 {头像更新失败。} */
    ERR_AVATAR_UPDATE(400312,"头像更新失败。"),
    /** 自定义 错误 返回码：400313 {用户更新失败。} */
    ERR_USER_UPDATE(400313,"用户更新失败。"),
    /** 自定义 错误 返回码：400314 {密码更新失败。} */
    ERR_PASSWORD_UPDATE(400314,"密码更新失败。"),
    /** 自定义 错误 返回码：400315 {数据操作失败。} */
    ERR_OPERATE_UPDATE(400315,"数据操作失败。"),
    /** 自定义 错误 返回码：400316 {[参数校验] 属性验证错误。} */
    ERR_ERROR_FILE(400316,"文件IO异常"),
    /** 自定义 错误 返回码：400317 {请勿重复操作。} */
    ERR_NOT_REPEAT_OPERATION(400317, "请勿重复操作。"),
    /** 自定义 错误 返回码：400318 {需要登录。} */
    ERR_NEED_LOGIN(400318,"需要登录。"),
    /** 自定义 错误 返回码：400319 {你已经退出了。} */
    ERR_DROP_OUT(400319, "你已经退出了。"),
    /** 自定义 错误 返回码：400320 {登录凭证过期。} */
    ERR_UNAUTHORIZED(400320,"登录凭证过期。"),
    /** 自定义 错误 返回码：400321 {非法token。} */
    ERR_ILLEGAL_TOKEN(400321, "非法token。"),
    /** 自定义 错误 返回码：400322 {token过期。} */
    ERR_TOKEN_EXPIRE(400322,"token过期。"),
    /** 自定义 错误 返回码：400323 {非法参数。} */
    ERR_ILLEGAL_ARGUMENT(400323,"非法参数。"),
    /** 自定义 错误 返回码：400324 {抱歉,你无权限访问。} */
    ERR_FORBIDDEN(400324,"抱歉,你无权限访问。"),
    /** 自定义 错误 返回码：400325 {请求的资源找不到。} */
    ERR_NOT_FOUND(400325, "请求的资源找不到。"),
    /** 自定义 错误 返回码：400326 {上传图片操作失败。} */
    ERR_IMAGE_UPLOAD(400326,"上传图片操作失败。"),

    /** 自定义 错误 返回码：400996 {拦截器错误。} */
    ERR_INTERCEPTOR(400996, "拦截器错误。"),
    /** 自定义 错误 返回码：400997 {服务器内部错误。} */
    ERR_INTERNAL_SERVER_ERROR(400997, "服务器内部错误。"),
    /** 自定义 错误 返回码：400998 {服务器正忙，请稍后再试。} */
    ERR_SERVICE_UNAVAILABLE(400998,"服务器正忙，请稍后再试。"),
    /** 自定义 错误 返回码：400999 {未知异常。} */
    UNKNOWN(400999,"未知异常。");

    ;

    /**
     * <h3>根据传入的 code 返回相应的enum值</h3>
     * @param code 状态标识
     * @return
     */
    public static HttpStatusCode get(int code) {
        for (HttpStatusCode statusCode : values()) {
            if (statusCode.getCode() == code) {
                return  statusCode;
            }
        }
        return null;
    }
    /**
     * <h3>私有的构造函数</h3>
     * @param code 结果状态 状态标识
     * @param msg 结果消息
     */
    private HttpStatusCode(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    /** 状态码 */
    private int code;
    /** 描述 */
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
