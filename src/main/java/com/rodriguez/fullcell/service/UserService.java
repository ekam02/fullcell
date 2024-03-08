package com.rodriguez.fullcell.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rodriguez.fullcell.model.UserModel;
import com.rodriguez.fullcell.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public UserModel createUser(UserModel user) {
        // Validación para asegurarse de que el usuario a crear no sea nulo
        if (user == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo");
        }

        // Puedes agregar más validaciones según tus requisitos antes de guardar el
        // usuario
        // ...

        return userRepository.save(user);
    }

    public UserModel updateUser(UserModel user) {
        // Validación para asegurarse de que el usuario a actualizar no sea nulo
        if (user == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo");
        }

        // Validar si el usuario existe antes de actualizar
        if (!userRepository.existsById(user.getId())) {
            throw new IllegalArgumentException("Usuario no encontrado para actualizar");
        }

        // Puedes agregar más validaciones según tus requisitos antes de actualizar el
        // usuario
        // ...

        return userRepository.save(user);
    }

    public String deleteUser(Integer id) {
        // Validar si el ID es nulo o negativo
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("ID de usuario no válido");
        }

        Optional<UserModel> findUser = userRepository.findById(id);

        // Validar si el usuario existe antes de eliminarlo
        if (findUser.isPresent()) {
            userRepository.deleteById(id);
            return "Usuario eliminado " + id;
        } else {
            return "Usuario no encontrado";
        }
    }

}
