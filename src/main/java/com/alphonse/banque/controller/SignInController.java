package com.alphonse.banque.controller;

import com.alphonse.banque.config.securite.jwt.JwtUtils;
import com.alphonse.banque.controller.request.SignInRequest;
import com.alphonse.banque.controller.response.SignInResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins ="*")
public class SignInController {
    //Comme c'est un bean on peut injecter directement comme ca dans le
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    //NB: Si on ne met pas de RequestBody on ne vas pas trouver l'utilisateur concerné
    @PostMapping("/connexion")
    public ResponseEntity<SignInResponse> signIn(@RequestBody SignInRequest request) {

        System.out.println("Je rentre pour la connexion ma request " + request);
        System.out.println("Je rentre pour la connexion ma request " + request);

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        SignInResponse signInResponse = new SignInResponse();
        signInResponse.setToken(jwt);
        System.out.println("Je rentre pour la connexion ma reponse" + signInResponse);
        System.out.println("Je rentre pour la connexion avec ma requete " + request);
        return ResponseEntity.ok(signInResponse);

    }


}


