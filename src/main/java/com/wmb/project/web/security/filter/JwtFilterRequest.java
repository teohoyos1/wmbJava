package com.wmb.project.web.security.filter;

import com.wmb.project.domain.service.ProjectUserDetailsService;
import com.wmb.project.web.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class JwtFilterRequest extends OncePerRequestFilter {

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private ProjectUserDetailsService projectUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer")){
            String jwt = authorizationHeader.substring(7);

            String username = jwtUtil.extractUsername(jwt);

            //Ver si el en el contexto aun no haya autenticación para este usuario
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null){
                UserDetails userDetails = projectUserDetailsService.loadUserByUsername(username);

                if (jwtUtil.validateToken(jwt, userDetails)){
                    //Levantar sesión para el usuario
                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    //Se le añaden los detalles de la conexion (Evaluar navegador,horario,OS)
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    //Se le setea en el contexto, la autenticacion con los datos del usuario
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            }

        }
        //El filtro se ha evualuado con filterChain
        filterChain.doFilter(request, response);
    }
}
