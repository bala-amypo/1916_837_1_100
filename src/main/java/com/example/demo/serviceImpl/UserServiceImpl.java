public User registerUser(User user) {

    if (userRepository.existsByEmail(user.getEmail())) {
        throw new ValidationException("Duplicate email");
    }

    user.setPassword(passwordEncoder.encode(user.getPassword()));

    if (user.getRole() == null) {
        user.setRole("USER");
    }

    return userRepository.save(user);
}
