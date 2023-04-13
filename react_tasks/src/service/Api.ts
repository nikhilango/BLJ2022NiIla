import axios, { AxiosInstance } from "axios";

const BASE_URL = 'https://api.thecatapi.com/vi/images';

export const defaultAxiosInstance: AxiosInstance = axios.create({baseURL: BASE_URL})