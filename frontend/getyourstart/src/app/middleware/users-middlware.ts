/*
@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/user")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        System.out.println(userRequest.getUsername());
        System.out.println(userRequest.getPassword());
        UserResponse userResponse = userService.createUser(userRequest);

        if (userResponse != null) {
            return ResponseEntity.ok(userResponse);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }  

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/user/authenticate")
    public ResponseEntity<UserResponse> Authenticate(@RequestBody AuthenticationRequest authenticationRequest, HttpSession session) {
        UserResponse userResponse = userService.Authenticate(authenticationRequest, session);

        if (userResponse != null) {
            return ResponseEntity.ok(userResponse);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/user/logout")
    public ResponseEntity<String> logOut(HttpSession session) {
        return userService.logOut(session);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/api/user/check")
    public ResponseEntity<UserResponse> getLoggedIn(HttpSession session) {
         UserResponse loggedIn = userService.getLoggedIn(session);

         if (loggedIn != null) {
            return ResponseEntity.ok(loggedIn);
         } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
         }
    }
}
*/

export async function createUser(userRequest : any) {
    const foundUserResponse : Response = await fetch("http://localhost:8080/api/user", {
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify(userRequest)
    });

    if (foundUserResponse.ok) {
        const foundUser = foundUserResponse.json();
        return foundUser;
    } else {
        return null;
    }
}

export async function authenticateUser(userRequest : any) {
    const foundUserResponse : Response = await fetch("http://localhost:8080/api/user/authenticate", {
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        credentials: 'include',  
        body : JSON.stringify(userRequest)
    });

    if (foundUserResponse.ok) {
        const foundUser = await foundUserResponse.json();
        return foundUser;
    } else {
        return null;
    }
}

export async function logoutUser() {
    const Response : Response = await fetch("http://localhost:8080/api/user/logout", {
        method : "POST",
    });

    if (Response.ok) {
        const message = await Response.text();
        console.log(message);
        return message;
    } else {
        return null;
    }
}

export async function getLoggedInUser() {
    const foundUserResponse : Response = await fetch("http://localhost:8080/api/user/check", {
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        credentials: 'include',  
    });

    if (foundUserResponse.ok) {
        const foundUser = await foundUserResponse.json();
        return foundUser;
    } else {
        return null;
    }
}