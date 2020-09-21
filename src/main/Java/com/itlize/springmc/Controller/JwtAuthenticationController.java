package com.itlize.springmc.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itlize.springmc.Model.AuthenticationRequest;
import com.itlize.springmc.Model.AuthenticationResponse;
import com.itlize.springmc.Service.JwtUserDetailsService;
import com.itlize.springmc.Service.UserService;
import com.itlize.springmc.Util.JwtUtil;

@CrossOrigin(origins = "*", allowedHeaders = "*",allowCredentials="true")
@RestController
public class JwtAuthenticationController {

	@Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(token,userService.getByUsername(authenticationRequest.getUsername())));
    }

    @RequestMapping(value = "/testtest", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:3000")
    public String test() {
    	return "it works";
    }
    
    @RequestMapping(value = "/refresh-token", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAuthenticationToken(@RequestHeader("Authorization") String token) throws Exception {
        token = token.substring(7);
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(jwtTokenUtil.getUsernameFromToken(token));
        final String strToken = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(strToken, userService.getByUsername(userDetails.getUsername())));
    }


    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
