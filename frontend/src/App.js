import { ChakraProvider } from '@chakra-ui/react';
import { MemoryRouter, Route, Routes } from 'react-router-dom';
import Login from './components/Login';
import Logout from './components/Logout';
import CustomerDashboard from './components/CustomerDashboard';
import AdminDashboard from './components/AdminDashboard';
import SignUp from './components/SignUp';

function App() {
    return (
        <ChakraProvider>
            <MemoryRouter>
                <Routes>
                    <Route path='/' element={<Login />}></Route>
                    <Route path='/signup' element={<SignUp />}></Route>
                    <Route path='/logout' element={<Logout />}></Route>
                    <Route
                        path='/customer'
                        element={<CustomerDashboard />}
                    ></Route>
                    <Route path='/admin' element={<AdminDashboard />}></Route>
                </Routes>
            </MemoryRouter>
        </ChakraProvider>
    );
}

export default App;
