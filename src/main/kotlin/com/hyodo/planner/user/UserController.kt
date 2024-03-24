package com.hyodo.planner.user

import com.google.firebase.auth.FirebaseAuthException
import com.hyodo.planner.security.Permission
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/admin")
class UserController(private val userService: UserService) {

    @Secured("ROLE_ANONYMOUS")
    @PostMapping("/user-claims/{uid}")
    @Throws(FirebaseAuthException::class)
    fun setUserClaims(
            @PathVariable uid: String?,
            @RequestBody requestedClaims: List<Permission>?
    ) {

        userService.setUserClaims(uid, requestedClaims.orEmpty())
    }
}