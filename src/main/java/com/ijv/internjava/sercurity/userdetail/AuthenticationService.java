package com.ijv.internjava.sercurity.userdetail;

import com.ijv.internjava.model.dto.ApiResponseDto;
import com.ijv.internjava.model.entity.Employee;
import com.ijv.internjava.model.entity.RoleName;
import com.ijv.internjava.model.entity.UserRole;
import com.ijv.internjava.repository.RoleRepository;
import com.ijv.internjava.repository.UserRoleRepository;
import com.ijv.internjava.sercurity.jwt.JwtService;
<<<<<<< HEAD
=======
import com.ijv.internjava.sercurity.payload.request.AuthenticationRequest;
>>>>>>> e975b92 (fix conflict)
import com.ijv.internjava.sercurity.payload.request.EmployeeUpdateRequest;
import com.ijv.internjava.sercurity.payload.request.PasswordUpdateRequest;
import com.ijv.internjava.sercurity.payload.request.RegisterRequest;
import com.ijv.internjava.service.EmployeeService;
import com.ijv.internjava.utils.CommonConstants;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
=======
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
>>>>>>> e975b92 (fix conflict)
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private RoleRepository roleRepository;

    public ApiResponseDto authenticate(AuthenticationRequest request, HttpServletRequest httpServletRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = EmployeeDetails.build(employeeService.findByUsername(request.getUsername())
                .orElseThrow());
        EmployeeResponse employeeResponse = new EmployeeResponse();
        BeanUtils.copyProperties(user, employeeResponse);
        AuthenticationResponse authenticationResponse = AuthenticationResponse.builder()
                .token(jwtService.generateAccessToken(httpServletRequest, user))
                .employeeResponse(employeeResponse)
                .build();
        return ApiResponseDto.builder()
                .data(authenticationResponse)
                .status(CommonConstants.ApiStatus.STATUS_OK)
                .build();
    }

    @Transactional(rollbackFor = SQLException.class)
    public ApiResponseDto register(RegisterRequest request) {
        List<String> error = validateRegister(request);
        if (error.isEmpty()) {
            Employee employee = new Employee();
            BeanUtils.copyProperties(request, employee);
            employee.setPassword(passwordEncoder.encode(request.getPassword()));
            employeeService.save(employee);
            for (String role : request.getRoles()) {
                userRoleRepository.save(new UserRole(employee,
                        roleRepository.findRoleByName(RoleName.fromString(role)).orElse(null)
                ));
            }
            return ApiResponseDto.builder()
                    .code("!23")
                    .message(CommonConstants.ApiStatus.STATUS_OK)
                    .build();
        }
        return ApiResponseDto.builder()
                .data(error)
                .message("User no valid")
                .status(CommonConstants.ApiStatus.STATUS_ERROR)
                .build();
    }

    public List<String> validateRegister(RegisterRequest request) {
        List<String> error = new LinkedList<>();
        if (employeeService.existsByEmail(request.getEmail())) {
            error.add("Email: " + request.getEmail() + " had been exist");
        }
        if (employeeService.existsByUsername(request.getUsername())) {
            error.add("Username: " + request.getUsername() + " had been exist");
        }
        if (employeeService.existsByPhone(request.getPhone())) {
            error.add("Phone: " + request.getPhone() + " had been exist");
        }
        if (!request.getPassword().equals(request.getConfirmPassword())) {
            error.add("Password and confirm password not match");
        }
        return error;
    }

    public ApiResponseDto sendError(BindingResult bindingResult) {
        return ApiResponseDto.builder()
                .status(CommonConstants.ApiStatus.STATUS_ERROR)
                .data(bindingResult.getAllErrors())
                .build();
    }

<<<<<<< HEAD
    public ApiResponseDto changePassword(PasswordUpdateRequest request , String jwt) {
        String newPassword = passwordEncoder.encode(request.getNewPassword());
        String username = jwtService.getUsernameFromToke(jwt.substring(7));
        Employee employee = employeeService.findByUsername(username).orElse(null);
        assert employee != null;
=======
    @Transactional(rollbackFor = UsernameNotFoundException.class)
    public ApiResponseDto changePassword(PasswordUpdateRequest request) {
        Employee employee = employeeService.findByUsername(request.getUsername()).orElseThrow(
                () -> new UsernameNotFoundException("not found username"));

        String newPassword = passwordEncoder.encode(request.getNewPassword());
<<<<<<< HEAD
>>>>>>> a3e137a (create update employee and change password)
=======
>>>>>>> e975b92 (fix conflict)
>>>>>>> 59b5f10 (Fix conflict on branch Customer Manager)
        employee.setPassword(newPassword);
        employeeService.save(employee);
        return ApiResponseDto.builder()
                .message("change password success")
                .status(CommonConstants.ApiStatus.STATUS_OK)
                .build();
    }

<<<<<<< HEAD
    public ApiResponseDto updateEmployee(EmployeeUpdateRequest request , String jwt){
        String username = jwtService.getUsernameFromToke(jwt.substring(7));
        Employee employee = employeeService.findByUsername(username).orElse(null);
        assert employee != null;
        BeanUtils.copyProperties(request,employee);
        employeeService.save(employee);
        return ApiResponseDto.builder()
                .message("change password success")
                .status(CommonConstants.ApiStatus.STATUS_OK)
=======
    public ApiResponseDto updateEmployee(EmployeeUpdateRequest request , Employee employee){
        BeanUtils.copyProperties(request,employee);
        employeeService.save(employee);
        return ApiResponseDto.builder()
                .message("Update success")
<<<<<<< HEAD
>>>>>>> a3e137a (create update employee and change password)
=======
>>>>>>> e975b92 (fix conflict)
>>>>>>> 59b5f10 (Fix conflict on branch Customer Manager)
                .build();
    }

}
