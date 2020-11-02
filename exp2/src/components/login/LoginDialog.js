import React, {useState} from 'react';
import Button from '@material-ui/core/Button';
import Dialog from '@material-ui/core/Dialog';
import DialogActions from '@material-ui/core/DialogActions';
import DialogContent from '@material-ui/core/DialogContent';
import DialogContentText from '@material-ui/core/DialogContentText';
import DialogTitle from '@material-ui/core/DialogTitle';
import TextField from "@material-ui/core/TextField";
import JwtService from "../../services/JwtService";
import {TOKEN_COOKIE_NAME} from "../../constant";
import * as cookie from "react-cookies";

export default function LoginDialog(props) {
    const [errorMessage, setErrorMessage] = useState("");
    const [isLoading, setLoading] = useState(false);
    let username;
    let password;

    return (
        <div>
            <Dialog
                open= {props.open}
                onClose={props.handleDialogClose}
                aria-labelledby="alert-dialog-title"
                aria-describedby="alert-dialog-description"
            >
                <DialogTitle id="alert-dialog-title">Please Login</DialogTitle>
                <DialogContent>
                    {/**/}
                    <TextField label="UserName"
                               fullWidth
                               autoFocus
                               disabled={isLoading}
                               onChange={e => username = e.target.value}/>
                    <TextField label="PassWord"
                               type="password"
                               fullWidth
                               disabled={isLoading}
                               onChange={e => password = e.target.value}
                    />
                    <DialogContentText id="alert-dialog-description" color="error">
                        {errorMessage}
                    </DialogContentText>
                </DialogContent>
                <DialogActions>
                    <Button onClick={props.handleDialogClose} color="primary">
                        Cancel
                    </Button>
                    <Button onClick={login} color="primary" disabled={isLoading}>
                        Login
                    </Button>
                </DialogActions>
            </Dialog>
        </div>
    );

    function login() {
        setErrorMessage("");
        setLoading(true);
        /// xhr
        JwtService.login(username,password)
            .then( response => {
                cookie.save(TOKEN_COOKIE_NAME, response.data.id_token);
                window.location.reload();
                })
            .catch( error => {
                console.error(error);
                const message = error.response.data.detail || error.response.data.title || error.response.data.error.message;
                setErrorMessage(message);
                }
            )
            .finally(() => setLoading(false));
    }
}
