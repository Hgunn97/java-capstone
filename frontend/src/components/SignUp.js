import {
    chakra,
    Flex,
    Stack,
    Box,
    Avatar,
    Heading,
    FormControl,
    Input,
    InputGroup,
    InputLeftElement,
    InputRightElement,
    Button,
    Link,
    RadioGroup,
    Radio,
    useToast,
} from '@chakra-ui/react';
import { FaUserAlt, FaLock } from 'react-icons/fa';
import axios from 'axios';
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const CFaUserAlt = chakra(FaUserAlt);
const CFaLock = chakra(FaLock);

function SignUp() {
    const [showPassword, setShowPassword] = useState(false);
    let [emailid, setEmailId] = useState('');
    let [password, setPassword] = useState('');
    let [repeatPassword, setRepeatPassword] = useState('');
    let [typeofuser, setTypeofUser] = useState('');
    let [error, setError] = useState('');
    let navigate = useNavigate();
    let toast = useToast();

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
                    'Please write emailid id or password or select type of user.',
                status: 'error',
                duration: 5000,
                isClosable: true,
                position: 'top',
            });
        } else if (password !== repeatPassword) {
            toast({
                title: 'Error',
                description: 'Passwords do not match. Please try again.',
                status: 'error',
                duration: 5000,
                isClosable: true,
                position: 'top',
            });
        } else {
            let login = { emailid, password, typeofuser };
            console.log(login);
            sessionStorage.setItem('user', emailid);

            if (typeofuser === 'admin') {
                navigate('/admin');
            } else {
                navigate('/customer');
            }

            // axios
            //     .post('http://localhost:9090/login/signUp', login)
            //     .then((result) => {
            //         sessionStorage.setItem('user', emailid);
            //         navigate('/customer');
            //     })
            //     .catch((error) => console.log(error));
        }
        setEmailId('');
        setPassword('');
        setRepeatPassword('');
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
                <Heading color='teal.400'>Welcome</Heading>
                <Box minW={{ base: '90%', md: '468px' }}>
                    <span style={{ color: 'red' }}>{error}</span>
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
                                        placeholder='Repeat Password'
                                        onChange={(e) =>
                                            setRepeatPassword(e.target.value)
                                        }
                                        value={repeatPassword}
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
                                Sign up
                            </Button>
                        </Stack>
                    </form>
                </Box>
            </Stack>
            <Box>
                Existing account?{' '}
                <Button colorScheme='teal' variant='link'>
                    Sign In
                </Button>
            </Box>
        </Flex>
    );
}

export default SignUp;
