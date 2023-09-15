import './App.css';
import EmailIcon from '@mui/icons-material/Email';
import LockIcon from '@mui/icons-material/Lock';
import CloseIcon from '@mui/icons-material/Close';
import DriveFileRenameOutlineIcon from '@mui/icons-material/DriveFileRenameOutline';
import {useState,useEffect} from "react";
import {Container,  Paper} from "@mui/material";
import axios from "axios";
function App() {
    const [state,setState] = useState(false);
    const [loginlink,setLoginlink] = useState(false);
    const [registerLink,setRegisterLink] = useState(false);
    const [mailCode,setMailCode]=useState(false)
    const [users,setUsers]=useState([])
    // const paperStyle={padding:'30px 20px', width:600,margin:"20px auto"}

    const[name,setName]=useState('')
    const[surname,setSurname]=useState('')
    const[email,setEmail]=useState('')
    const[code,setCode]=useState('')
    const[statuscode,setStatusCode]=useState('')
    const[status,setStatus]=useState('')
    const[password,setPassword]=useState('')


    const handleClick=(e)=>{
        e.preventDefault()
        const user={name,surname,email,password}
        console.log(user)
        fetch("http://localhost:8080/app/v1/users",{
            method:"POST",
            headers:{"Content-Type":"application/json"},
            body:JSON.stringify(user)
        }
            // .then(res=>res.json())
            // .then((result)=>{
            //         setStatus(result);})
        )
    }
    const handleCode=(e)=>{
        axios.get(`http://localhost:8080/app/v1/users/`+code)
    }
    // useEffect(()=>{
    //     axios.get(`http://localhost:8080/app/v1/users`)
    //         .then((result)=>{
    //             setUsers(result);
    //         })
    // },[])
    return (
        <div className="App">
            {/*<body>*/}
            <header>
                <h2 className={"logo"}>Logo</h2>
                <nav className={"navigation"}>
                    <a href="#">Home</a>
                    <a href="#">About</a>
                    <a href="#">Service</a>
                    <a href="#" className={"contact"}>Contact</a>
                    <button className={"btnLogin-popup"} onClick={()=> setLoginlink(st=> !st)}>Login</button>
                </nav>
            </header>
            <div className={`wrapper ${loginlink ? "active-popup" : ''} ${registerLink ? "active" : ''} ${mailCode ? "active-code" : ''}`}>
                <span className="icon-close" onClick={()=>setRegisterLink()/setLoginlink(st=> !st)}><CloseIcon/></span>
                <div className={`form-box login`}>
                    <h2>Login</h2>
                    <form action={"#"}>
                        <div className="input-box">
                            <span className="icon"><EmailIcon/></span>
                            <input type="email" placeholder={"Email"} required/>
                        </div>
                        <div className="input-box">
                            <span className="icon"><LockIcon/></span>
                            <input type="password" placeholder={"Password"} required/>
                        </div>
                        <div className="remember-forgot">
                            <label><input type="checkbox"/>Remember me</label>
                            <a href="#">Forgot Password?</a>
                        </div>
                        <button type={"submit"} className={"btn"}>Login</button>
                        <div className="login-register">
                            <p>Dont't have an account<a href="#" className={"register-link"} onClick={()=> setRegisterLink(st=> !st)}> Register</a></p>
                        </div>

                    </form>
                </div>
                {/*//Register*/}
                <div className={`form-box register `} >
                    <h2>Registration</h2>
                    <form action={"#"}>
                        <div className="input-box">
                            <span className="icon"><DriveFileRenameOutlineIcon/></span>
                            <input type="text" placeholder={"Name"} required
                                   value={name}
                                   onChange={(e)=>setName(e.target.value)}/>
                        </div>
                        <div className="input-box">
                            <span className="icon"><DriveFileRenameOutlineIcon/></span>
                            <input type="text" placeholder={"Surname"} required
                                   value={surname}
                                   onChange={(e)=>setSurname(e.target.value)}/>
                        </div>
                        <div className="input-box">
                            <span className="icon"><EmailIcon/></span>
                            <input type="email" placeholder={"Email"} required
                                   value={email}
                                   onChange={(e)=>setEmail(e.target.value)}/>
                        </div>
                        <div className="input-box">
                            <span className="icon"><LockIcon/></span>
                            <input type="password" placeholder={"Password"} required
                                   value={password}
                                   onChange={(e)=>setPassword(e.target.value)}/>
                        </div>
                        <div className="remember-forgot">
                            <label><input type="checkbox"/>
                            I agree to the terms & conditions</label>
                        </div>
                        <button type={"submit"} className={"btn"} onClick={()=> {setMailCode(true)}} onClickCapture={handleClick}>Send</button>
                        <div className="login-register">
                            <p>Already have an account<a href="#" className={"login-link"}  onClick={()=> setRegisterLink(st=> !st)}> Login</a></p>
                        </div>

                    </form>
                </div>
                        {mailCode===true ?(
                                <div className="code-box">
                                    <input className={"code-input"} type="text" placeholder={"Code"} maxLength={"10"} required
                                           value={code}
                                           onChange={(e)=>setCode(e.target.value)}/>
                                    <button type={"submit"} className={"btn"} onClick={()=>setMailCode(false)} onClickCapture={handleCode}>Register</button>
                                </div>
                        ):(<p1></p1>)}

            </div>
            <div className="cards">
            {/*<Container>*/}
                <div className="usercard">
                    {/*{*/}
                    {/*    users.map((user)=>{*/}
                    {/*    // <Paper elevation={6} style={{margin:"10px",padding:"15px", textAlign:"left"}} >*/}
                    {/*    <Paper elevation={6} style={{margin:"10px",padding:"15px", textAlign:"left"}} key={user.surname}>*/}
                    {/*        Id:{user.name}<br/>*/}
                    {/*        Name:{user.surname}<br/>*/}
                    {/*        Address:{user.email}*/}

                    {/*    </Paper>*/}

                    {/*    }*/}
                    {/*    )}*/}
                </div>
            {/*</Container>*/}
            </div>
        </div>
    );
}

export default App;
