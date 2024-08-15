import { Button } from '@chakra-ui/react';
import { useNavigate } from 'react-router-dom';

function Logout() {
    let navigate = useNavigate();

    let handleLogout = () => {
        sessionStorage.removeItem('user');
        navigate('/');
    };
    return (
        <div>
            <Button value='logout' onClick={handleLogout}>
                Sign out
            </Button>
        </div>
    );
}

export default Logout;
