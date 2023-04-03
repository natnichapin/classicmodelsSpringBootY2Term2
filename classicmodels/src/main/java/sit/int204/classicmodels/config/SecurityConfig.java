//package sit.int204.classicmodels.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//import org.springframework.security.web.util.matcher.RequestMatcher;
//
//import java.util.List;
//
//import static org.springframework.http.HttpMethod.OPTIONS;
//
//@Configuration
////@EnableWebSecurity
//@RequiredArgsConstructor
//public class SecurityConfig {
//
//    private final AuthenticationConfiguration authConfiguration;
//
//    //เขียนอันนี้ จะทำให้ controller Autowire AuthenticationManager ได้
//    @Bean
//    public AuthenticationManager authenticationManager() throws Exception {
//        return authConfiguration.getAuthenticationManager();
//    }
//    @Bean
//    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeHttpRequests((requests) -> requests
//                        .requestMatchers(OPTIONS).permitAll() // allow CORS option calls for Swagger UI
//                        //end point ที่เข้าได้โดยไม่ต้อง login
//                        .requestMatchers("/authenticate", "/api/products").permitAll()
//                        .anyRequest().authenticated())
//                .httpBasic();
//        return http.build();
//    }
//    //password encoder เราใช้อะไร
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
