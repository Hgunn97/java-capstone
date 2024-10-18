import {
    chakra,
    Flex,
    Stack,
    Box,
    Avatar,
    Heading,
    FormControl,
    FormHelperText,
    Input,
    InputGroup,
    InputLeftElement,
    InputRightElement,
    Button,
    Link,
    RadioGroup,
    Radio,
    Alert,
    AlertIcon,
    AlertTitle,
    CloseButton,
    useToast,
} from '@chakra-ui/react';
import { FaUserAlt, FaLock } from 'react-icons/fa';
import axios from 'axios';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const CFaUserAlt = chakra(FaUserAlt);
const CFaLock = chakra(FaLock);

function Login() {
    const [showPassword, setShowPassword] = useState(false);
    let [emailid, setEmailId] = useState('');
    let [password, setPassword] = useState('');
    let [typeofuser, setTypeofUser] = useState('');
    let navigate = useNavigate();
    const toast = useToast();

    const handleShowClick = () => setShowPassword(!showPassword);

    let handleSubmit = (event) => {
        event.preventDefault();
        if (
            emailid.length == 0 ||
            password.length == 0 ||
            typeofuser.length == 0
        ) {
            toast({
                title: 'Error',
                description:
                    'Please enter your email, password, and select the type of user.',
                status: 'error',
                duration: 5000,
                isClosable: true,
                position: 'top',
            });
        } else {
            let login = { emailid, password, typeofuser };

            console.log(login);

            axios
                .post('http://localhost:9090/login/signIn', login)
                .then((result) => {
                    if (result.data == 'Customer login successfully') {
                        sessionStorage.setItem('user', emailid);
                        navigate('/customer');
                    } else if (result.data == 'Admin login successfully') {
                        navigate('/admin');
                    } else {
                        toast({
                            title: 'Error',
                            description: result.data,
                            status: 'error',
                            duration: 5000,
                            isClosable: true,
                            position: 'top',
                        });
                    }
                })
                .catch((error) => console.log(error));
        }
        setEmailId('');
        setPassword('');
    };
    return (
        <Flex
            flexDirection='column'
            width='100wh'
            height='100vh'
            justifyContent='center'
            alignItems='center'
        >
            <Stack
                flexDir='column'
                mb='2'
                justifyContent='center'
                alignItems='center'
            >
                <Avatar bg='teal.500' />
                <Heading color='teal.400'>Welcome back</Heading>
                <Box minW={{ base: '90%', md: '468px' }}>
                    <form onSubmit={handleSubmit}>
                        <Stack
                            spacing={4}
                            p='1rem'
                            backgroundColor='whiteAlpha.900'
                            boxShadow='md'
                        >
                            <FormControl>
                                <InputGroup>
                                    <InputLeftElement
                                        pointerEvents='none'
                                        children={
                                            <CFaUserAlt color='gray.300' />
                                        }
                                    />
                                    <Input
                                        type='email'
                                        placeholder='email address'
                                        onChange={(e) =>
                                            setEmailId(e.target.value)
                                        }
                                        value={emailid}
                                    />
                                </InputGroup>
                            </FormControl>
                            <FormControl>
                                <InputGroup>
                                    <InputLeftElement
                                        pointerEvents='none'
                                        color='gray.300'
                                        children={<CFaLock color='gray.300' />}
                                    />
                                    <Input
                                        type={
                                            showPassword ? 'text' : 'password'
                                        }
                                        placeholder='Password'
                                        onChange={(e) =>
                                            setPassword(e.target.value)
                                        }
                                        value={password}
                                    />
                                    <InputRightElement width='4.5rem'>
                                        <Button
                                            h='1.75rem'
                                            size='sm'
                                            onClick={handleShowClick}
                                        >
                                            {showPassword ? 'Hide' : 'Show'}
                                        </Button>
                                    </InputRightElement>
                                </InputGroup>
                                <FormHelperText textAlign='right'>
                                    <Link>forgot password?</Link>
                                </FormHelperText>
                            </FormControl>
                            <FormControl>
                                <InputGroup>
                                    <RadioGroup>
                                        <Stack direction='row'>
                                            <Radio
                                                value='admin'
                                                onChange={(e) =>
                                                    setTypeofUser(
                                                        e.target.value
                                                    )
                                                }
                                            >
                                                Admin
                                            </Radio>
                                            <Radio
                                                value='customer'
                                                onChange={(e) =>
                                                    setTypeofUser(
                                                        e.target.value
                                                    )
                                                }
                                            >
                                                Customer
                                            </Radio>
                                        </Stack>
                                    </RadioGroup>
                                </InputGroup>
                            </FormControl>
                            <Button
                                borderRadius={0}
                                type='submit'
                                variant='solid'
                                colorScheme='teal'
                                width='full'
                            >
                                Login
                            </Button>
                        </Stack>
                    </form>
                </Box>
            </Stack>
            <Box>
                New to us?{' '}
                <Button
                    onClick={() => navigate('/signup')}
                    colorScheme='teal'
                    variant='link'
                >
                    Sign Up
                </Button>
            </Box>
        </Flex>
    );
}

export default Login;
